public class Branch {
    private String rentalBranch;

    public Branch(String rentalBranch) {
        this.rentalBranch = rentalBranch;
    }

    public String getRentalBranch() {
        return rentalBranch;
    }

    public void setRentalBranch(String rentalBranch) {
        this.rentalBranch = rentalBranch;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "rentalBranch='" + rentalBranch + '\'' +
                '}';
    }
}
