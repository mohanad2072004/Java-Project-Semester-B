import java.util.ArrayList;

public class Client {
    private LicenceDetails licence;
    private ContactDetails contact;

    public Client(String drivingLicence, int validity, ArrayList<String> restrictions, String name, String surname, int age, String address, String phonenumber, String email) {
        licence = new LicenceDetails(drivingLicence,validity, restrictions);
        contact = new ContactDetails(name, surname ,age, address, phonenumber, email);
    }

    public Client(LicenceDetails licence, ContactDetails contact) {
        this.licence = licence;
        this.contact = contact;
    }

    public LicenceDetails getLicence() {
        return licence;
    }

    public void setLicence(LicenceDetails licence) {
        this.licence = licence;
    }

    public ContactDetails getContact() {
        return contact;
    }

    public void setContact(ContactDetails contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Client{" +
                "licence=" + licence +
                ", contact=" + contact +
                '}';
    }
}
