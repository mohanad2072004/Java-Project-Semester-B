package models;

public class FinalizedRecord extends ProcessedRecord {

    private PaymentDetails paymentDetails;
    private PickupDetails pickupDetails;

    // ----- Constructor: full parameters -----
    public FinalizedRecord(Client client, Car car, Agent agent,
            SimpleDate startDate, SimpleDate endDate, int rentalDays, double baseCost,
            InsuranceOption insuranceOption,
            Discount discount,
            double depositAmount,
            PaymentDetails paymentDetails,
            PickupDetails pickupDetails) {
        super(client, car, agent, startDate, endDate, rentalDays, baseCost, insuranceOption, discount, depositAmount);

        if (paymentDetails == null) {
            throw new IllegalArgumentException("Payment details cannot be null");
        }
        if (pickupDetails == null) {
            throw new IllegalArgumentException("Pickup details cannot be null");
        }

        this.paymentDetails = paymentDetails;
        this.pickupDetails = pickupDetails;
    }

    // ----- Constructor: build from an existing ProcessedRecord -----
    public FinalizedRecord(ProcessedRecord pr, PaymentDetails paymentDetails, PickupDetails pickupDetails) {
        super(pr, pr.getInsuranceOption(), pr.getDiscount(), pr.getDepositAmount());

        if (paymentDetails == null) {
            throw new IllegalArgumentException("Payment details cannot be null");
        }
        if (pickupDetails == null) {
            throw new IllegalArgumentException("Pickup details cannot be null");
        }

        this.paymentDetails = paymentDetails;
        this.pickupDetails = pickupDetails;
    }

    // ----- Getters -----
    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public PickupDetails getPickupDetails() {
        return pickupDetails;
    }

    // ----- Setters -----
    public void setPaymentDetails(PaymentDetails paymentDetails) {
        if (paymentDetails == null) {
            throw new IllegalArgumentException("Payment details cannot be null");
        }
        this.paymentDetails = paymentDetails;
    }

    public void setPickupDetails(PickupDetails pickupDetails) {
        if (pickupDetails == null) {
            throw new IllegalArgumentException("Pickup details cannot be null");
        }
        this.pickupDetails = pickupDetails;
    }

    @Override
    public String toString() {
        return "FinalizedRecord{" +
                "client=" + getClient() +
                ", car=" + getCar() +
                ", agent=" + getAgent() +
                ", startDate=" + getStartDate() +
                ", endDate=" + getEndDate() +
                ", rentalDays=" + getRentalDays() +
                ", baseCost=" + getBaseCost() +
                ", insuranceOption=" + getInsuranceOption() +
                ", discount=" + getDiscount() +
                ", depositAmount=" + getDepositAmount() +
                ", totalCost=" + getTotalCost() +
                ", paymentDetails=" + paymentDetails +
                ", pickupDetails=" + pickupDetails +
                '}';
    }
}
