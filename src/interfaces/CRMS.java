package interfaces;

import models.Agent;
import models.BookingRecord;
import models.Car;
import models.Client;
import models.Discount;
import models.FinalizedRecord;
import models.InsuranceOption;
import models.ProcessedRecord;
import models.RentalSystem;
import models.SimpleDate;

public interface CRMS {

  RentalSystem initializeRentalSystem(int numOfClients, int numOfCars, int numOfAgents);

  BookingRecord book(Client client, Car car, Agent agent, SimpleDate startDate, SimpleDate endDate);

  ProcessedRecord process(
      BookingRecord bookingRecord,
      InsuranceOption insuranceOption,
      Discount discount,
      double depositAmount);

  FinalizedRecord finalize(ProcessedRecord processedRecord);
}