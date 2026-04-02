# Car Rental Management System (CRMS)

## Project Overview

The Car Rental Management System (CRMS) is a Java-based OOP project that simulates the full lifecycle of a car rental, from booking and processing to finalization and pickup.

The system supports:

- Initializing a rental environment with clients, cars, and agents
- Booking available cars with date-based cost calculation
- Processing bookings with insurance options, discounts, and deposits
- Finalizing rentals with payment confirmation and pickup scheduling
- Comparing multiple booking deals to pick the cheapest option

The project is built around clean object-oriented design: every concept in the system maps to a dedicated class, and the whole workflow is driven through the `CRMS` interface implemented by `CarRentalImplementer`.

---

## Project Structure

```
src
├── enums
│   ├── Days.java
│   ├── FuelType.java
│   └── Transmission.java
│
├── interfaces
│   └── CRMS.java
│
├── models
│   ├── Agent.java
│   ├── BookingRecord.java
│   ├── Branch.java
│   ├── Car.java
│   ├── Client.java
│   ├── ContactDetails.java
│   ├── Discount.java
│   ├── Features.java
│   ├── FinalizedRecord.java
│   ├── InsuranceDetails.java
│   ├── InsuranceOption.java
│   ├── LicenseDetails.java
│   ├── PaymentDetails.java
│   ├── PickupDetails.java
│   ├── ProcessedRecord.java
│   ├── RentalSystem.java
│   ├── Schedule.java
│   └── SimpleDate.java
│
├── implementation
│   └── CarRentalImplementer.java
│
└── test
    └── TestRental.java
```

---

## Workflow

```
initializeRentalSystem()
         ↓
       book()          ← picks client, car, agent, start/end dates
         ↓
     process()         ← applies insurance, discount, deposit
         ↓
     finalize()        ← confirms payment, sets pickup details
```

---

## OOP Concepts Used

### Encapsulation

All fields across every class are `private`. Access goes through getters and setters, and most setters include validation so bad data never sneaks in.

### Inheritance

The three record classes build on each other:

```
BookingRecord
└── ProcessedRecord
    └── FinalizedRecord
```

`ProcessedRecord` adds insurance, discount, and deposit on top of the base booking. `FinalizedRecord` adds payment and pickup details on top of that. Each constructor can either take raw parameters or wrap an existing parent object, which made writing `CarRentalImplementer` much cleaner.

### Composition

Most classes are built from smaller classes rather than having everything in one giant object:

- `Client` contains `LicenseDetails` and `ContactDetails`
- `Car` contains `Features` and `InsuranceDetails`
- `Agent` contains `Branch` and `Schedule`
- `FinalizedRecord` contains `PaymentDetails` and `PickupDetails`

Both `Agent` and `Car` also support two constructors: one that takes the sub-objects directly, and one that takes raw primitive fields and builds the sub-objects internally.

### Interfaces

`CRMS` defines the four core operations the system must support. `CarRentalImplementer` implements all of them. This means the test class only depends on the interface type (`CRMS system = new CarRentalImplementer()`), which keeps things loosely coupled.

### Validation

Validation is done in constructors and setters rather than leaving it to the caller. A few examples:

- `Client` requires age ≥ 18
- `Schedule` requires working hours between 0 and 24
- `LicenseDetails` throws if validity ≤ 0
- `ContactDetails` rejects emails that don't contain `@`
- `Discount` enforces percentage between 0 and 100
- `ProcessedRecord` prevents deposit from exceeding total cost
- `PaymentDetails` auto-calculates outstanding balance and sets `paymentConfirmed` to true if deposit covers everything

---

## Class Breakdown

### SimpleDate

A lightweight custom date class we wrote instead of using `java.util.Date` or `LocalDate`, to keep things simple. Each month is assumed to have 30 days (12 × 30 = 360 days/year). The key method is the static `rentalDays(start, end)` which converts both dates to total day counts and returns the difference. `BookingRecord` uses this to auto-recalculate rental days if the start or end date is updated via a setter.

### Client

Holds the client's name, surname, and age, along with two composed objects:

- `LicenseDetails` - license number, validity in days, and optional restrictions list
- `ContactDetails` - address, phone number, and email (validated with `@` check)

### Car

Holds brand, model, registration number, daily rate, and availability flag, plus:

- `Features` - fuel type, transmission, seating capacity, category
- `InsuranceDetails` - provider info, coverage options, and optional add-ons (stored as `ArrayList<String>`)

### Agent

Holds two composed objects:

- `Branch` - branch name, location, phone number
- `Schedule` - working hours (float), working days (`ArrayList<Days>`), availability flag

### BookingRecord

The base record created when a client books a car. Stores the client, car, agent, start/end dates, rental days, and base cost (`dailyRate × rentalDays`). Setting a new start or end date via the setter automatically recalculates `rentalDays`.

### ProcessedRecord (extends BookingRecord)

Adds `InsuranceOption`, `Discount`, and `depositAmount` on top of the booking. The `totalCost` is calculated internally:

```
totalCost = baseCost + insuranceCost
totalCost -= totalCost × (discountPercentage / 100)
totalCost = max(totalCost, 0)
```

Updating insurance or discount via setters recalculates the total automatically.

### FinalizedRecord (extends ProcessedRecord)

Adds `PaymentDetails` and `PickupDetails`. Can be constructed from raw parameters or directly from an existing `ProcessedRecord`. In `CarRentalImplementer.finalize()`, the pickup branch is pulled from the agent's branch name and the payment method defaults to `"Card"`.

### PaymentDetails

Tracks deposit paid, total rental cost, outstanding balance, payment method, and a `paymentConfirmed` boolean. The outstanding balance is always `totalCost - depositPaid`, and `paymentConfirmed` is set to `true` automatically when the balance reaches zero.

### PickupDetails

Holds the pickup branch name, pickup date (as a `SimpleDate`), and optional special instructions. In the implementation, instructions default to `"Bring driving license and payment confirmation"`.

### Discount

Holds a discount type label (e.g. `"Promo10"`, `"Loyalty"`, `"Corporate"`) and a percentage between 0 and 100.

### InsuranceOption

Holds insurance type (e.g. `"Standard"`, `"Premium"`), a cost, and a coverage description. This is different from `InsuranceDetails` - `InsuranceDetails` belongs to the car and describes the car's insurance provider. `InsuranceOption` is what the client chooses when processing a booking.

### RentalSystem

A container that holds three `ArrayList`s: agents, clients, and cars. Supports `add`/`remove` for each. Initialized by `CarRentalImplementer.initializeRentalSystem()`.

### Schedule

Stores working hours, a list of working days (`ArrayList<Days>`), and an availability flag. Working hours must be between 0 and 24 - otherwise it throws.

### CarRentalImplementer

The only class that implements `CRMS`. Each method does focused work:

- `initializeRentalSystem` - creates empty lists and returns a new `RentalSystem`
- `book` - validates inputs, calculates rental days via `SimpleDate.rentalDays()`, computes base cost, returns a `BookingRecord`
- `process` - wraps a `BookingRecord` into a `ProcessedRecord` with insurance/discount/deposit applied
- `finalize` - builds `PaymentDetails` and `PickupDetails` from the processed record and returns a `FinalizedRecord`

---

## Enums

### Days

`SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY`

Used in `Schedule` to define which days an agent works.

### FuelType

`GAS, DIESEL, ELECTRIC, HYBRID`

### Transmission

`MANUAL, AUTOMATIC`

---

## CRMS Interface

```java
RentalSystem initializeRentalSystem(int numOfClients, int numOfCars, int numOfAgents);

BookingRecord book(Client client, Car car, Agent agent, SimpleDate startDate, SimpleDate endDate);

ProcessedRecord process(BookingRecord bookingRecord, InsuranceOption insuranceOption,
                        Discount discount, double depositAmount);

FinalizedRecord finalize(ProcessedRecord processedRecord);
```

---

## Test Scenario (TestRental.java)

The test file demonstrates a realistic scenario:

1. A client (`Omar Hassaan`, age 22) is created with a valid license and contact details.
2. A `Toyota Corolla` at 250.5/day is set up with AXA insurance and two coverage options.
3. Two agents are created - one in Cairo (Branch A) and one in Giza (Branch B).
4. The same car is booked for 10 days (01/05/2026 → 11/05/2026) with each agent separately.
5. Two different insurance and discount combinations are processed:
   - Booking 1: Standard insurance (100.0), Promo10 discount (10%)
   - Booking 2: Premium insurance (200.0), Promo5 discount (5%)
6. The cheaper total cost is selected.
7. The best deal is finalized and the full summary is printed.

Sample output includes a side-by-side cost breakdown of both bookings, a best deal section, and the finalized booking with pickup and payment details.

---

## Possible Future Improvements

- Replace `SimpleDate` with `java.time.LocalDate` for real calendar accuracy
- Use `Scanner` for interactive input instead of hardcoded test data
- Add a cancel/refund flow with partial deposit return
- Support multiple payment methods beyond `"Card"`
- Add branch-specific pricing rules
- Persist data to a file or database
- Build a simple GUI or web interface

---

## Authors

This project was developed by:

- **Moaz Ahmed Ahmed Mahmoud Elbakly** (202300715) - Group Leader
- **Mostafa Sherif Mohamed Amer** (202300745)
- **Khaled Abdelhamid Elbatal** (202200724)
- **Omar Ibrahim Fathy Ibrahim Mohamed Hassaan** (202301790)
- **Mohaned Ahmed Aly Hassan Saleh** (202400014)
