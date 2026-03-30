import java.util.ArrayList;

public class InsuranceDetails {
    // ---------- insurance provider details ----------------------
    private String insuranceProvider;
    private String insuranceProviderAddress;
    private String insuranceProviderPhoneNumber;
    // ------------------------------------------------------------
    private ArrayList<String> coverageOption;
    private ArrayList<String> optionalAddOns;

    public InsuranceDetails(String insuranceProvider, String insuranceProviderAddress, String insuranceProviderPhoneNumber, ArrayList<String> coverageOption,
                            ArrayList<String> optionalAddOns) {
        this.insuranceProvider = insuranceProvider;
        this.insuranceProviderAddress = insuranceProviderAddress;
        this.insuranceProviderPhoneNumber = insuranceProviderPhoneNumber;
        this.coverageOption = coverageOption;
        this.optionalAddOns = optionalAddOns;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public String getInsuranceProviderAddress() {
        return insuranceProviderAddress;
    }

    public void setInsuranceProviderAddress(String insuranceProviderAddress) {
        this.insuranceProviderAddress = insuranceProviderAddress;
    }

    public String getInsuranceProviderPhoneNumber() {
        return insuranceProviderPhoneNumber;
    }

    public void setInsuranceProviderPhoneNumber(String insuranceProviderPhoneNumber) {
        this.insuranceProviderPhoneNumber = insuranceProviderPhoneNumber;
    }

    public ArrayList<String> getCoverageOption() {
        return coverageOption;
    }

    public void setCoverageOption(ArrayList<String> coverageOption) {
        this.coverageOption = coverageOption;
    }

    public ArrayList<String> getOptionalAddOns() {
        return optionalAddOns;
    }

    public void setOptionalAddOns(ArrayList<String> optionalAddOns) {
        this.optionalAddOns = optionalAddOns;
    }

    public void addCoverageOption(String option){coverageOption.add(option);}

    public void removeCoverageOption(String option){coverageOption.remove(option);}

    public void addAddOn(String addon){optionalAddOns.add(addon);}

    public void removeAddOn(String addon){optionalAddOns.remove(addon);}

    @Override
    public String toString() {
        return "Insurance details{" +
                "insurance Provider name:'" + insuranceProvider + '\'' +
                ", insuranceProviderAddress:'" + insuranceProviderAddress + '\'' +
                ", insurance Provider's Phone Number:'" + insuranceProviderPhoneNumber + '\'' +
                ", coverage options:" + coverageOption +
                ", optional add-ons:" + optionalAddOns +
                '}';
    }
}
