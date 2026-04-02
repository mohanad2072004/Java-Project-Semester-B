package models;

public class PickupDetails {

    private String pickupBranch;
    private SimpleDate pickupDate;
    private String specialInstructions;

    public PickupDetails(String pickupBranch, SimpleDate pickupDate, String specialInstructions) {
        if (pickupBranch == null || pickupBranch.isEmpty()) {
            throw new IllegalArgumentException("Pickup branch cannot be empty");
        }
        if (pickupDate == null) {
            throw new IllegalArgumentException("Pickup date cannot be empty");
        }
        this.pickupBranch = pickupBranch;
        this.pickupDate = pickupDate;
        this.specialInstructions = specialInstructions;
    }

    public String getPickupBranch() {
        return pickupBranch;
    }

    public SimpleDate getPickupDate() {
        return pickupDate;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setPickupBranch(String pickupBranch) {
        if (pickupBranch == null || pickupBranch.isEmpty()) {
            throw new IllegalArgumentException("Pickup branch cannot be empty");
        }
        this.pickupBranch = pickupBranch;
    }

    public void setPickupDate(SimpleDate pickupDate) {
        if (pickupDate == null) {
            throw new IllegalArgumentException("Pickup date cannot be empty");
        }
        this.pickupDate = pickupDate;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    @Override
    public String toString() {
        return "PickupDetails{" +
                "pickupBranch='" + pickupBranch + '\'' +
                ", pickupDate=" + pickupDate +
                ", specialInstructions='" + specialInstructions + '\'' +
                '}';
    }
}
