package models;

import java.util.ArrayList;

public class Client {

    private String name;
    private String surname;
    private int age;

    private LicenseDetails license;
    private ContactDetails contact;

    public Client(String name, String surname, int age,
            String drivingLicense, int validity, ArrayList<String> restrictions,
            String address, String phoneNumber, String email) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException("Surname cannot be empty");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Client must be at least 18 years old");
        }

        this.name = name;
        this.surname = surname;
        this.age = age;

        this.license = new LicenseDetails(drivingLicense, validity, restrictions);
        this.contact = new ContactDetails(address, phoneNumber, email);
    }

    public Client(String name, String surname, int age,
            LicenseDetails license, ContactDetails contact) {

        this.name = name;
        this.surname = surname;
        this.age = age;
        this.license = license;
        this.contact = contact;
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

    public LicenseDetails getLicense() {
        return license;
    }

    public void setLicense(LicenseDetails license) {
        this.license = license;
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
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", license=" + license +
                ", contact=" + contact +
                '}';
    }
}