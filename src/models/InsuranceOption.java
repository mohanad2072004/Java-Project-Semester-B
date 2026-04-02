package models;

public class InsuranceOption {

    private String insuranceType; // e.g. "Standard", "Premium"
    private double insuranceCost;
    private String coverageDescription;

    public InsuranceOption(String insuranceType, double insuranceCost, String coverageDescription) {
        if (insuranceType == null || insuranceType.isEmpty()) {
            throw new IllegalArgumentException("Insurance type cannot be empty");
        }
        if (insuranceCost < 0) {
            throw new IllegalArgumentException("Insurance cost cannot be negative");
        }
        this.insuranceType = insuranceType;
        this.insuranceCost = insuranceCost;
        this.coverageDescription = coverageDescription;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public double getInsuranceCost() {
        return insuranceCost;
    }

    public String getCoverageDescription() {
        return coverageDescription;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setInsuranceCost(double insuranceCost) {
        if (insuranceCost < 0) {
            throw new IllegalArgumentException("Insurance cost cannot be negative");
        }
        this.insuranceCost = insuranceCost;
    }

    public void setCoverageDescription(String coverageDescription) {
        this.coverageDescription = coverageDescription;
    }

    @Override
    public String toString() {
        return "InsuranceOption{" +
                "insuranceType='" + insuranceType + '\'' +
                ", insuranceCost=" + insuranceCost +
                ", coverageDescription='" + coverageDescription + '\'' +
                '}';
    }
}
