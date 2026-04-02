package models;

public class ProcessedRecord extends BookingRecord {

    private InsuranceOption insuranceOption;
    private Discount discount;
    private double depositAmount;
    private double totalCost; // baseCost + insuranceCost - discount amount

    // ----- Constructor -----
    public ProcessedRecord(Client client, Car car, Agent agent, SimpleDate startDate, SimpleDate endDate,
            int rentalDays,
            double baseCost,
            InsuranceOption insuranceOption,
            Discount discount,
            double depositAmount) {
        super(client, car, agent, startDate, endDate, rentalDays, baseCost);

        this.totalCost = calculateTotalCost(baseCost, insuranceOption, discount);

        if (depositAmount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        if (depositAmount > totalCost) {
            throw new IllegalArgumentException("Deposit amount cannot exceed total cost");
        }

        this.insuranceOption = insuranceOption;
        this.discount = discount;
        this.depositAmount = depositAmount;
    }

    // ----- Constructor: build from an existing BookingRecord -----
    public ProcessedRecord(BookingRecord br,
            InsuranceOption insuranceOption,
            Discount discount,
            double depositAmount) {
        super(br.getClient(), br.getCar(), br.getAgent(), br.getStartDate(), br.getEndDate(), br.getRentalDays(),
                br.getBaseCost());

        this.totalCost = calculateTotalCost(br.getBaseCost(), insuranceOption, discount);

        if (depositAmount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        if (depositAmount > totalCost) {
            throw new IllegalArgumentException("Deposit amount cannot exceed total cost");
        }

        this.insuranceOption = insuranceOption;
        this.discount = discount;
        this.depositAmount = depositAmount;
    }

    // ----- Helper: compute total cost -----
    private double calculateTotalCost(double baseCost,
            InsuranceOption insurance,
            Discount discount) {
        double cost = baseCost;

        if (insurance != null) {
            cost += insurance.getInsuranceCost();
        }

        if (discount != null) {
            cost -= cost * (discount.getDiscountPercentage() / 100.0);
        }

        return Math.max(cost, 0);
    }

    // ----- Getters -----
    public InsuranceOption getInsuranceOption() {
        return insuranceOption;
    }

    public Discount getDiscount() {
        return discount;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    // ----- Setters -----
    public void setInsuranceOption(InsuranceOption insuranceOption) {
        this.insuranceOption = insuranceOption;
        this.totalCost = calculateTotalCost(getBaseCost(), insuranceOption, this.discount);
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
        this.totalCost = calculateTotalCost(getBaseCost(), this.insuranceOption, discount);
    }

    public void setDepositAmount(double depositAmount) {
        if (depositAmount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        if (depositAmount > totalCost) {
            throw new IllegalArgumentException("Deposit amount cannot exceed total cost");
        }
        this.depositAmount = depositAmount;
    }

    @Override
    public String toString() {
        return "ProcessedRecord{" +
                "client=" + getClient() +
                ", car=" + getCar() +
                ", agent=" + getAgent() +
                ", startDate=" + getStartDate() +
                ", endDate=" + getEndDate() +
                ", rentalDays=" + getRentalDays() +
                ", baseCost=" + getBaseCost() +
                ", insuranceOption=" + insuranceOption +
                ", discount=" + discount +
                ", depositAmount=" + depositAmount +
                ", totalCost=" + totalCost +
                '}';
    }
}
