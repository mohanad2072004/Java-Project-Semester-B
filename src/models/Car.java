package models;

import java.util.ArrayList;

import enums.FuelType;
import enums.Transmission;

public class Car {

    private String brand;
    private String model;
    private String registrationNumber;
    private double dailyRate;
    private boolean available;

    private Features features;
    private InsuranceDetails details;

    public Car(String brand, String model, String registrationNumber,
            double dailyRate, boolean available,
            FuelType fuelType, Transmission transmission,
            int seatingCapacity, String category,
            String insuranceProvider, String insuranceProviderAddress,
            String insuranceProviderPhoneNumber,
            ArrayList<String> coverageOption,
            ArrayList<String> optionalAddOns) {

        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }

        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty");
        }

        if (registrationNumber == null || registrationNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be empty");
        }

        if (dailyRate < 0) {
            throw new IllegalArgumentException("Daily rate cannot be negative");
        }

        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.dailyRate = dailyRate;
        this.available = available;

        this.features = new Features(fuelType, transmission, seatingCapacity, category);

        this.details = new InsuranceDetails(
                insuranceProvider,
                insuranceProviderAddress,
                insuranceProviderPhoneNumber,
                coverageOption,
                optionalAddOns);
    }

    public Car(String brand, String model, String registrationNumber,
            double dailyRate, boolean available,
            Features features, InsuranceDetails details) {

        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.dailyRate = dailyRate;
        this.available = available;
        this.features = features;
        this.details = details;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty");
        }
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be empty");
        }
        this.registrationNumber = registrationNumber;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        if (dailyRate < 0) {
            throw new IllegalArgumentException("Daily rate cannot be negative");
        }
        this.dailyRate = dailyRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", dailyRate=" + dailyRate +
                ", available=" + available +
                ", features=" + features +
                ", details=" + details +
                '}';
    }
}