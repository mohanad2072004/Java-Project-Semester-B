package models;

import java.util.ArrayList;

public class LicenseDetails {

    private String drivingLicense;
    private int validity; // validity period in days
    private ArrayList<String> restrictions;

    public LicenseDetails(String drivingLicense, int validity, ArrayList<String> restrictions) {
        this.drivingLicense = drivingLicense;
        if (validity <= 0) {
            throw new IllegalArgumentException("Driving license is not valid."); // changed the output
        }
        this.validity = validity;
        this.restrictions = restrictions;
    }

    public ArrayList<String> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(ArrayList<String> restrictions) {
        this.restrictions = restrictions;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public void addRestriction(String r) {
        if (this.restrictions == null) {
            this.restrictions = new ArrayList<>();
        }
        this.restrictions.add(r);
    }

    public void removeRestriction(String r) {
        if (r == null) {
            throw new IllegalArgumentException("Restriction cannot be null.");
        }

        if (this.restrictions == null || this.restrictions.isEmpty()) {
            throw new IllegalStateException("No restrictions to remove.");
        }

        this.restrictions.remove(r);
    }

    @Override
    public String toString() {
        return "LicenseDetails{" +
                "drivingLicense='" + drivingLicense + '\'' +
                ", validity=" + validity +
                ", restrictions=" + restrictions +
                '}';
    }
}
