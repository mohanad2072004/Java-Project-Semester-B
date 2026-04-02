package models;

public class BookingRecord {

    private Client client;
    private Car car;
    private Agent agent;
    private SimpleDate startDate; // format: DD/MM/YYYY
    private SimpleDate endDate; // format: DD/MM/YYYY
    private int rentalDays;
    private double baseCost; // daily rate * rental days

    // ----- Constructor: full objects -----
    public BookingRecord(Client client, Car car, Agent agent,
            SimpleDate startDate, SimpleDate endDate, int rentalDays, double baseCost) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }

        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }

        if (agent == null) {
            throw new IllegalArgumentException("Agent cannot be null");
        }

        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Rental days must be greater than 0");
        }

        if (baseCost < 0) {
            throw new IllegalArgumentException("Base cost cannot be negative");
        }

        if (startDate == null) {
            throw new IllegalArgumentException("Start date cannot be empty");
        }

        if (endDate == null) {
            throw new IllegalArgumentException("End date cannot be empty");
        }

        this.startDate = startDate;
        this.endDate = endDate;
        this.rentalDays = rentalDays;
        this.client = client;
        this.car = car;
        this.agent = agent;
        this.baseCost = baseCost;
    }

    // ----- Getters -----
    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }

    public Agent getAgent() {
        return agent;
    }

    public SimpleDate getStartDate() {
        return startDate;
    }

    public SimpleDate getEndDate() {
        return endDate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getBaseCost() {
        return baseCost;
    }

    // ----- Setters -----
    public void setClient(Client client) {
        this.client = client;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public void setStartDate(SimpleDate startDate) {
        if (startDate == null)
            throw new IllegalArgumentException("Start date cannot be null");
        this.startDate = startDate;
        // Recalculate rentalDays
        this.rentalDays = SimpleDate.rentalDays(this.startDate, this.endDate);
    }

    public void setEndDate(SimpleDate endDate) {
        if (endDate == null)
            throw new IllegalArgumentException("End date cannot be null");
        this.endDate = endDate;
        // Recalculate rentalDays
        this.rentalDays = SimpleDate.rentalDays(this.startDate, this.endDate);
    }

    public void setBaseCost(double baseCost) {
        if (baseCost < 0) {
            throw new IllegalArgumentException("Base cost cannot be negative");
        }
        this.baseCost = baseCost;
    }

    @Override
    public String toString() {
        return "BookingRecord{" +
                "client=" + client +
                ", car=" + car +
                ", agent=" + agent +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", rentalDays=" + getRentalDays() +
                ", baseCost=" + baseCost +
                '}';
    }
}
