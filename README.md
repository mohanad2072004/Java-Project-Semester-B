# Car Rental Management System (CRMS)

## Project Overview

The Car Rental Management System (CRMS) is a Java-based project designed to simulate the full rental journey of a customer renting a car.

The system allows:

- Clients to make car bookings
- Agents to manage rental bookings
- Cars to be assigned and reserved
- Insurance and discounts to be applied
- Payments and pickup details to be finalized

The project follows Object-Oriented Programming (OOP) principles and is built using classes, inheritance, composition, interfaces, validation, and modular design.

---

## Project Objectives

The goal of this project is to:

- Build a complete rental booking workflow
- Apply Java OOP concepts in a realistic system
- Organize the code into reusable and maintainable classes
- Simulate the booking, processing, and finalization stages of car rental

---

## Main Features

### 1. Rental System Initialization

The system can be initialized with a number of:

- Clients
- Cars
- Agents

This creates a complete rental environment ready for bookings.

### 2. Booking a Car

A client can book an available car through an assigned agent.

The booking record contains:

- Client details
- Car details
- Agent details
- Rental duration
- Start and end dates
- Base rental cost

### 3. Processing a Booking

A booking can be processed by applying:

- Insurance options
- Discounts
- Deposit requirements

The processed booking calculates the total rental cost.

### 4. Finalizing a Booking

A processed booking can be finalized by:

- Confirming payment
- Setting pickup details
- Reserving the car

Once finalized, the car becomes unavailable for other bookings.

---

## OOP Concepts Used

This project uses several Object-Oriented Programming concepts:

### Encapsulation

All fields are private and accessed through getters and setters.

### Inheritance

The following inheritance structure is used:

```text
BookingRecord
└── ProcessedRecord
    └── FinalizedRecord
```

### Composition

Classes are built using other classes.

Examples:

- A Client contains LicenseDetails and ContactDetails
- A Car contains Features and InsuranceDetails
- An Agent contains Branch and Schedule

### Interfaces

The CRMS interface defines the main methods required for the rental system.

### Validation

Input validation is used in constructors and setters to prevent invalid values.

Examples:

- Negative costs are not allowed
- Empty names are not allowed
- Invalid email addresses are rejected
- Rental days must be greater than zero

---

## Project Structure

```text
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
│   └── Schedule.java
│
├── implementation
│   └── CarRentalImplementer.java
│
└── test
    └── TestRental.java
```

---

## Main Classes

### Client

Stores customer information including:

- Name
- Surname
- Age
- License details
- Contact details

### Car

Stores car information including:

- Brand
- Model
- Registration number
- Daily rate
- Availability
- Features
- Insurance details

### Agent

Stores information about the rental agent including:

- Branch
- Work schedule
- Availability

### BookingRecord

Represents the initial booking stage.

### ProcessedRecord

Extends BookingRecord by adding:

- Insurance option
- Discount
- Deposit amount
- Total cost

### FinalizedRecord

Extends ProcessedRecord by adding:

- Payment details
- Pickup details

---

## Enums Used

### Days

Represents working days for agent schedules.

### FuelType

Represents car fuel type.

Examples:

- PETROL
- DIESEL
- ELECTRIC
- HYBRID

### Transmission

Represents the transmission type of a car.

Examples:

- MANUAL
- AUTOMATIC

---

## CRMS Interface Methods

### initializeRentalSystem(int numOfClients, int numOfCars, int numOfAgents)

Creates and returns a RentalSystem object.

### book(Client client, Car car, Agent agent)

Creates a BookingRecord using the selected client, car, and agent.

### process(BookingRecord bookingRecord)

Applies insurance, discounts, and deposit rules.

Returns a ProcessedRecord.

### finalizeBooking(ProcessedRecord processedRecord)

Confirms payment and pickup details.

Returns a FinalizedRecord.

---

## Workflow of the System

```text
Initialize Rental System
          ↓
Book a Car
          ↓
Process the Booking
          ↓
Finalize the Rental
```

---

## Example Scenario

1. A client selects a car.
2. An agent handles the booking.
3. A booking record is created.
4. Insurance and discounts are added.
5. The final cost is calculated.
6. Payment is confirmed.
7. Pickup details are generated.
8. The car becomes unavailable.

---

## Future Improvements

Some possible future improvements for this project include:

- Using LocalDate instead of String dates
- Adding a graphical user interface (GUI)
- Saving data to files or databases
- Allowing dynamic user input with Scanner
- Adding branch-specific pricing rules
- Supporting multiple payment methods
- Adding cancellation and refund logic
- Connecting the project to a real database

---

## Authors

This project was developed by:

- Moaz Ahmed Ahmed Mahmoud Elbakly (202300715) – Group Leader
- Mostafa Sherif Mohamed Amer (202300745)
- Khaled Abdelhamid Elbatal (202200724)
- Omar Ibrahim Fathy Ibrahim Mohamed Hassaan (202301790)
- Mohaned Ahmed Aly Hassan Saleh (202400014)
