package implementation;

import java.util.ArrayList;

import interfaces.CRMS;
import models.Agent;
import models.BookingRecord;
import models.Car;
import models.Client;
import models.Discount;
import models.FinalizedRecord;
import models.InsuranceOption;
import models.PaymentDetails;
import models.PickupDetails;
import models.ProcessedRecord;
import models.RentalSystem;

public class CarRentalImplementer implements CRMS {

  @Override
  public RentalSystem initializeRentalSystem(int numOfClients, int numOfCars, int numOfAgents) {

    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Agent> agents = new ArrayList<>();

    for (int i = 0; i < numOfClients; i++) {
      clients.add(null);
    }

    for (int i = 0; i < numOfCars; i++) {
      cars.add(null);
    }

    for (int i = 0; i < numOfAgents; i++) {
      agents.add(null);
    }

    return new RentalSystem(agents, clients, cars);
  }

  @Override
  public BookingRecord book(Client client, Car car, Agent agent) {

    if (client == null) {
      throw new IllegalArgumentException("Client cannot be null");
    }

    if (car == null) {
      throw new IllegalArgumentException("Car cannot be null");
    }

    if (agent == null) {
      throw new IllegalArgumentException("Agent cannot be null");
    }

    if (!car.isAvailable()) {
      throw new IllegalArgumentException("Car is not available for booking");
    }

    int rentalDays = 5;
    String startDate = "01/04/2026";
    String endDate = "06/04/2026";

    double baseCost = car.getDailyRate() * rentalDays;

    return new BookingRecord(
        client,
        car,
        agent,
        startDate,
        endDate,
        rentalDays,
        baseCost);
  }

  @Override
  public ProcessedRecord process(BookingRecord bookingRecord) {

    if (bookingRecord == null) {
      throw new IllegalArgumentException("Booking record cannot be null");
    }

    InsuranceOption insuranceOption = new InsuranceOption(
        "Standard",
        100.0,
        "Basic accident and theft coverage");

    Discount discount = new Discount(
        "Promotional",
        10.0);

    double depositAmount = 500.0;

    return new ProcessedRecord(
        bookingRecord,
        insuranceOption,
        discount,
        depositAmount);
  }

  @Override
  public FinalizedRecord finalizeBooking(ProcessedRecord processedRecord) {

    if (processedRecord == null) {
      throw new IllegalArgumentException("Processed record cannot be null");
    }

    PaymentDetails paymentDetails = new PaymentDetails(
        processedRecord.getDepositAmount(),
        processedRecord.getTotalCost(),
        "Card");

    PickupDetails pickupDetails = new PickupDetails(
        processedRecord.getAgent().getBranch().getRentalBranch(),
        "07/04/2026",
        "Bring driving license and payment confirmation");

    processedRecord.getCar().setAvailable(false);

    return new FinalizedRecord(
        processedRecord,
        paymentDetails,
        pickupDetails);
  }
}