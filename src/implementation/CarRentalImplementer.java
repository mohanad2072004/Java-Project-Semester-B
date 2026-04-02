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
import models.SimpleDate;

public class CarRentalImplementer implements CRMS {

  @Override
  public RentalSystem initializeRentalSystem(int numOfClients, int numOfCars, int numOfAgents) {

    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Agent> agents = new ArrayList<>();

    return new RentalSystem(agents, clients, cars);
  }

  @Override
  public BookingRecord book(Client client, Car car, Agent agent, SimpleDate startDate, SimpleDate endDate) {

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

    if (startDate == null || endDate == null) {
      throw new IllegalArgumentException("Dates cannot be null");
    }

    int rentalDays = SimpleDate.rentalDays(startDate, endDate);

    if (rentalDays <= 0) {
      throw new IllegalArgumentException("End date must be after start date");
    }

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
  public ProcessedRecord process(
      BookingRecord bookingRecord,
      InsuranceOption insuranceOption,
      Discount discount,
      double depositAmount) {

    if (bookingRecord == null) {
      throw new IllegalArgumentException("Booking record cannot be null");
    }

    return new ProcessedRecord(
        bookingRecord,
        insuranceOption,
        discount,
        depositAmount);
  }

  @Override
  public FinalizedRecord finalize(ProcessedRecord processedRecord) {

    if (processedRecord == null) {
      throw new IllegalArgumentException("Processed record cannot be null");
    }

    PaymentDetails paymentDetails = new PaymentDetails(
        processedRecord.getDepositAmount(),
        processedRecord.getTotalCost(),
        "Card");

    PickupDetails pickupDetails = new PickupDetails(
        processedRecord.getAgent().getBranch().getRentalBranch(),
        processedRecord.getStartDate(),
        "Bring driving license and payment confirmation");

    return new FinalizedRecord(
        processedRecord,
        paymentDetails,
        pickupDetails);
  }
}