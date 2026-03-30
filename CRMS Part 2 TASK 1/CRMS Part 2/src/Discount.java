public class Discount {

    private String discountType;        // e.g. "Loyalty", "Promotional", "Corporate"
    private double discountPercentage;  // e.g. 10.0 means 10%

    public Discount(String discountType, double discountPercentage) {
        if (discountType == null || discountType.isEmpty()) {
            throw new IllegalArgumentException("Discount type cannot be empty");
        }
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        this.discountType       = discountType;
        this.discountPercentage = discountPercentage;
    }

    public String getDiscountType()        { return discountType; }
    public double getDiscountPercentage()  { return discountPercentage; }

    public void setDiscountType(String discountType) {
        if (discountType == null || discountType.isEmpty()) {
            throw new IllegalArgumentException("Discount type cannot be empty");
        }
        this.discountType = discountType;
    }
    public void setDiscountPercentage(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountType='" + discountType + '\'' +
                ", discountPercentage=" + discountPercentage + "%" +
                '}';
    }
}
