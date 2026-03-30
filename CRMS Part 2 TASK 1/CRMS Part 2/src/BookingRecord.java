public class BookingRecord {

    private Client client;
    private Car car;
    private Agent agent;
    private String startDate;   // format: DD/MM/YYYY
    private String endDate;     // format: DD/MM/YYYY
    private int rentalDays;
    private double baseCost;    // daily rate * rental days

    // ----- Constructor: full objects -----
    public BookingRecord(Client client, Car car, Agent agent,
                         String startDate, String endDate,
                         int rentalDays, double baseCost) {
        if (client == null) { throw new IllegalArgumentException("Client cannot be null"); }
        if (car == null)    { throw new IllegalArgumentException("Car cannot be null"); }
        if (agent == null)  { throw new IllegalArgumentException("Agent cannot be null"); }
        if (rentalDays <= 0){ throw new IllegalArgumentException("Rental days must be greater than 0"); }
        if (baseCost < 0)   { throw new IllegalArgumentException("Base cost cannot be negative"); }

        this.client     = client;
        this.car        = car;
        this.agent      = agent;
        this.startDate  = startDate;
        this.endDate    = endDate;
        this.rentalDays = rentalDays;
        this.baseCost   = baseCost;
    }

    // ----- Getters -----
    public Client getClient() { return client; }
    public Car getCar()       { return car; }
    public Agent getAgent()   { return agent; }
    public String getStartDate()  { return startDate; }
    public String getEndDate()    { return endDate; }
    public int getRentalDays()    { return rentalDays; }
    public double getBaseCost()   { return baseCost; }

    // ----- Setters -----
    public void setClient(Client client)   { this.client = client; }
    public void setCar(Car car)            { this.car = car; }
    public void setAgent(Agent agent)      { this.agent = agent; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public void setEndDate(String endDate)     { this.endDate = endDate; }
    public void setRentalDays(int rentalDays)  {
        if (rentalDays <= 0) { throw new IllegalArgumentException("Rental days must be greater than 0"); }
        this.rentalDays = rentalDays;
    }
    public void setBaseCost(double baseCost) {
        if (baseCost < 0) { throw new IllegalArgumentException("Base cost cannot be negative"); }
        this.baseCost = baseCost;
    }

    @Override
    public String toString() {
        return "BookingRecord{" +
                "client=" + client +
                ", car=" + car +
                ", agent=" + agent +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", rentalDays=" + rentalDays +
                ", baseCost=" + baseCost +
                '}';
    }
}
