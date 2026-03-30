public class Features {
    private FuelType fuelType;
    private Transmission transmission;
    private int seatingCapacity;
    private String category;

    public Features(FuelType fuelType, Transmission transmission, int seatingCapacity, String category) {
        this.fuelType = fuelType;
        this.transmission = transmission;
        if(seatingCapacity <=0){throw new IllegalArgumentException("Invalid seats");}
        this.seatingCapacity = seatingCapacity;
        this.category = category;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Features{" +
                "fuel type:" + fuelType +
                ", transmission:" + transmission +
                ", seating capacity:" + seatingCapacity +
                ", category:'" + category + '\'' +
                '}';
    }
}
