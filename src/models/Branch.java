package models;

public class Branch {

    private String rentalBranch;
    private String location;
    private String phoneNumber;

    public Branch(String rentalBranch, String location, String phoneNumber) {

        if (rentalBranch == null || rentalBranch.trim().isEmpty()) {
            throw new IllegalArgumentException("Branch name cannot be empty");
        }

        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be empty");
        }

        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }

        this.rentalBranch = rentalBranch;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public String getRentalBranch() {
        return rentalBranch;
    }

    public void setRentalBranch(String rentalBranch) {
        if (rentalBranch == null || rentalBranch.trim().isEmpty()) {
            throw new IllegalArgumentException("Branch name cannot be empty");
        }
        this.rentalBranch = rentalBranch;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be empty");
        }
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "rentalBranch='" + rentalBranch + '\'' +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}