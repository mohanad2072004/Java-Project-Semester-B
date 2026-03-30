public class ContactDetails {
    private String name;
    private String surname;
    private int age;
    private String address;
    private String phonenumber;
    private String email;


    public ContactDetails(String name, String surname, int age, String address, String phonenumber, String email) {
        if (name.isEmpty() || name.matches(".*\\d.*")) {          //check if a string has a number or is not entered
            throw new IllegalArgumentException("Invalid name");
        } else {
            this.name = name;
        }

        if (surname.isEmpty() || surname.matches(".*\\d.*")) {          //check if a string has a number or is not entered
            throw new IllegalArgumentException("Invalid surname");
        } else {
            this.surname = surname;
        }

        if (age < 18 || age > 100) {
            throw new IllegalArgumentException("Invalid age");
        } else {
            this.age = age;
        }
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
