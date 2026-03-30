import java.util.ArrayList;

public class Car {
    private Features features;
    private InsuranceDetails details;

    public Car(FuelType fuelType, Transmission transmission, int seatingCapacity, String category, String insuranceProvider,
               String insuranceProviderAddress, String insuranceProviderPhoneNumber, ArrayList<String> coverageOption,
               ArrayList<String> optionalAddOns){
        features = new Features(fuelType,transmission,seatingCapacity,category);
        details = new InsuranceDetails(insuranceProvider,insuranceProviderAddress,insuranceProviderPhoneNumber,coverageOption,optionalAddOns);
    }

    public Car(Features features, InsuranceDetails details) {
        this.features = features;
        this.details = details;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public InsuranceDetails getDetails() {
        return details;
    }

    public void setDetails(InsuranceDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Car{" +
                "features=" + features +
                ", details=" + details +
                '}';
    }
}
