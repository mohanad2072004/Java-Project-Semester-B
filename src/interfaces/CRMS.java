package interfaces;

import models.Agent;
import models.BookingRecord;
import models.Car;
import models.Client;
import models.FinalizedRecord;
import models.ProcessedRecord;
import models.RentalSystem;

public interface CRMS {

  RentalSystem initializeRentalSystem(int numOfClients, int numOfCars, int numOfAgents);

  BookingRecord book(Client client, Car car, Agent agent);

  ProcessedRecord process(BookingRecord bookingRecord);

  FinalizedRecord finalizeBooking(ProcessedRecord processedRecord);
}