import java.util.ArrayList;
public class LicenceDetails {

    private String drivingLicence;
    private int validity;                   //validity period in days
    private ArrayList<String> restrictions;

    public LicenceDetails(String drivingLicence, int validity, ArrayList<String> restrictions) {
        this.drivingLicence = drivingLicence;
        if(validity <=0){throw new IllegalArgumentException("Invalid Validity or expired");}
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

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public void addRestriction(String r){restrictions.add(r);}
    public void removeRestriction(String r){restrictions.remove(r);}

    @Override
    public String toString() {
        return "LicenceDetails{" +
                "drivingLicence='" + drivingLicence + '\'' +
                ", validity=" + validity +
                ", restrictions=" + restrictions +
                '}';
    }
}
