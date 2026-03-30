public class PaymentDetails {

    private double depositPaid;
    private double totalRentalCost;
    private double outstandingBalance;  // totalRentalCost - depositPaid
    private String paymentMethod;       // e.g. "Card", "Cash", "Bank Transfer"
    private boolean paymentConfirmed;

    public PaymentDetails(double depositPaid, double totalRentalCost, String paymentMethod) {
        if (depositPaid < 0)    { throw new IllegalArgumentException("Deposit paid cannot be negative"); }
        if (totalRentalCost < 0){ throw new IllegalArgumentException("Total rental cost cannot be negative"); }
        if (paymentMethod == null || paymentMethod.isEmpty()) {
            throw new IllegalArgumentException("Payment method cannot be empty");
        }

        this.depositPaid        = depositPaid;
        this.totalRentalCost    = totalRentalCost;
        this.outstandingBalance = totalRentalCost - depositPaid;
        this.paymentMethod      = paymentMethod;
        this.paymentConfirmed   = (outstandingBalance <= 0);
    }

    public double getDepositPaid()        { return depositPaid; }
    public double getTotalRentalCost()    { return totalRentalCost; }
    public double getOutstandingBalance() { return outstandingBalance; }
    public String getPaymentMethod()      { return paymentMethod; }
    public boolean isPaymentConfirmed()   { return paymentConfirmed; }

    public void setDepositPaid(double depositPaid) {
        if (depositPaid < 0) { throw new IllegalArgumentException("Deposit paid cannot be negative"); }
        this.depositPaid        = depositPaid;
        this.outstandingBalance = this.totalRentalCost - depositPaid;
        this.paymentConfirmed   = (outstandingBalance <= 0);
    }
    public void setTotalRentalCost(double totalRentalCost) {
        if (totalRentalCost < 0) { throw new IllegalArgumentException("Total rental cost cannot be negative"); }
        this.totalRentalCost    = totalRentalCost;
        this.outstandingBalance = totalRentalCost - this.depositPaid;
        this.paymentConfirmed   = (outstandingBalance <= 0);
    }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public void setPaymentConfirmed(boolean paymentConfirmed) { this.paymentConfirmed = paymentConfirmed; }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "depositPaid=" + depositPaid +
                ", totalRentalCost=" + totalRentalCost +
                ", outstandingBalance=" + outstandingBalance +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentConfirmed=" + paymentConfirmed +
                '}';
    }
}
