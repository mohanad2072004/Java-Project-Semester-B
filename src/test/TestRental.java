package test;

import java.util.ArrayList;

import enums.Days;
import enums.FuelType;
import enums.Transmission;
import implementation.CarRentalImplementer;
import interfaces.CRMS;
import models.Agent;
import models.BookingRecord;
import models.Branch;
import models.Car;
import models.Client;
import models.ContactDetails;
import models.Discount;
import models.Features;
import models.FinalizedRecord;
import models.InsuranceDetails;
import models.InsuranceOption;
import models.LicenseDetails;
import models.ProcessedRecord;
import models.Schedule;
import models.SimpleDate;

public class TestRental {

        public static void main(String[] args) {

                CRMS system = new CarRentalImplementer();

                // 1️⃣ Initialize system
                system.initializeRentalSystem(1, 1, 2);

                // =========================
                // -- Client
                // =========================
                LicenseDetails license = new LicenseDetails("12345", 365, new ArrayList<>());
                ContactDetails contact = new ContactDetails("Cairo", "0100000000", "omar@mail.com");

                Client client = new Client("Omar", "Hassaan", 22, license, contact);

                // =========================
                // -- Car
                // =========================
                ArrayList<String> coverage = new ArrayList<>();
                coverage.add("Theft");
                coverage.add("Accident");

                ArrayList<String> addons = new ArrayList<>();
                addons.add("Premium Support");

                Features features = new Features(
                                FuelType.GAS,
                                Transmission.AUTOMATIC,
                                5,
                                "Sedan");

                InsuranceDetails insuranceDetails = new InsuranceDetails(
                                "AXA",
                                "Cairo",
                                "0222222222",
                                coverage,
                                addons);

                Car car = new Car(
                                "Toyota",
                                "Corolla",
                                "ABC-123",
                                250.5,
                                true,
                                features,
                                insuranceDetails);

                // =========================
                // -- Agents
                // =========================
                ArrayList<Days> days = new ArrayList<>();
                days.add(Days.SUNDAY);
                days.add(Days.MONDAY);

                Branch branch1 = new Branch("Branch A", "Cairo", "111-111");
                Schedule schedule1 = new Schedule(8.0f, days, true);

                Agent agent1 = new Agent(branch1, schedule1);

                Branch branch2 = new Branch("Branch B", "Giza", "222-222");
                Schedule schedule2 = new Schedule(8.0f, days, true);

                Agent agent2 = new Agent(branch2, schedule2);

                // =========================
                // -- Dates
                // =========================
                SimpleDate start = new SimpleDate(1, 5, 2026);
                SimpleDate end = new SimpleDate(11, 5, 2026);

                // =========================
                // 2️⃣ Bookings
                // =========================
                BookingRecord booking1 = system.book(client, car, agent1, start, end);

                car.setAvailable(true); // IMPORTANT

                BookingRecord booking2 = system.book(client, car, agent2, start, end);

                // =========================
                // 3️⃣ Process (different deals)
                // =========================
                InsuranceOption insurance1 = new InsuranceOption("Standard", 100.0, "Basic");
                Discount discount1 = new Discount("Promo10", 10.0);

                InsuranceOption insurance2 = new InsuranceOption("Premium", 200.0, "Full");
                Discount discount2 = new Discount("Promo5", 5.0);

                ProcessedRecord processed1 = system.process(booking1, insurance1, discount1, 500.0);
                ProcessedRecord processed2 = system.process(booking2, insurance2, discount2, 500.0);

                // =========================
                // 4️⃣ Compare
                // =========================
                ProcessedRecord bestDeal = (processed1.getTotalCost() <= processed2.getTotalCost())
                                ? processed1
                                : processed2;

                // =========================
                // 5️⃣ Finalize
                // =========================
                FinalizedRecord finalized = system.finalize(bestDeal);

                // =========================
                // ✅ Output Bookings
                // =========================
                System.out.println("\n");

                // Print both bookings
                printBookingSummary("Booking 1 Summary", processed1);
                printBookingSummary("Booking 2 Summary", processed2);

                // Print comparison result
                printBestDealInfo(bestDeal);

                // Print finalized booking last
                printFinalizedBooking(finalized, bestDeal == processed1 ? "Booking 1" : "Booking 2");
        }

        // =========================
        // Helper Methods
        // =========================
        // Helper method to print booking summary with cost breakdown
        public static void printBookingSummary(String title, ProcessedRecord booking) {
                String branchName = booking.getAgent().getBranch().getRentalBranch();
                String location = booking.getAgent().getBranch().getLocation();
                String clientName = booking.getClient().getName() + " " + booking.getClient().getSurname();
                String carName = booking.getCar().getBrand() + " " + booking.getCar().getModel();

                System.out.println("================ " + title.toUpperCase() + " ================");
                System.out.println("Rental Branch: " + branchName);
                System.out.println("Pickup Location: " + location);
                System.out.println("Client: " + clientName);
                System.out.println("Car: " + carName + " (" + booking.getCar().getRegistrationNumber() + ")");
                System.out.println("Rental Days: " + booking.getRentalDays());

                // Cost breakdown
                double baseCost = booking.getBaseCost();
                double insuranceCost = booking.getInsuranceOption().getInsuranceCost();
                double discountAmount = (booking.getDiscount().getDiscountPercentage() / 100.0)
                                * (baseCost + insuranceCost);
                double totalCost = booking.getTotalCost();

                System.out.println("Base Cost: " + baseCost);
                System.out.println("Insurance Cost: " + insuranceCost);
                System.out.println("Discount Applied: " + booking.getDiscount().getDiscountType() +
                                " (" + booking.getDiscount().getDiscountPercentage() + "%) = -" + discountAmount);
                System.out.println("Total Cost: " + totalCost);

                System.out.println("==================================================\n");
        }

        // Helper method for printing just the best deal info
        public static void printBestDealInfo(ProcessedRecord bestDeal) {
                System.out.println("=================== BEST DEAL =====================");
                System.out.println("Selected Branch: " + bestDeal.getAgent().getBranch().getRentalBranch());
                System.out.println("Lowest Total Cost: " + bestDeal.getTotalCost());
                System.out.println("Reason: This booking is the cheapest among the compared options.");
                System.out.println("==================================================\n");
        }

        // Helper method for printing finalized booking
        public static void printFinalizedBooking(FinalizedRecord finalized, String selectedBooking) {
                System.out.println("================ FINALIZED BOOKING ================");
                System.out.println("Selected Booking: " + selectedBooking);
                System.out.println("Pickup Branch: " + finalized.getPickupDetails().getPickupBranch());
                System.out.println("Pickup Date: " + finalized.getPickupDetails().getPickupDate());
                System.out.println("Deposit Paid: " + finalized.getPaymentDetails().getDepositPaid());
                System.out.println("Outstanding Balance: " + finalized.getPaymentDetails().getOutstandingBalance());
                System.out.println("==================================================\n");
        }
}
