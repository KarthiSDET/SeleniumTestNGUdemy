package org.selenium.pom.objects;

public class BillingAddress {

    private String firstName;
    private String lastName;
    private String addressLineOne;
    private String city;
    private int postalCode;
    private String email;
    private String country;
    private String state;

    public BillingAddress() {

    }

    public BillingAddress(String firstName, String lastName, String addressLineOne, String city,
        int postalCode, String email, String country, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLineOne = addressLineOne;
        this.city = city;
        this.postalCode = postalCode;
        this.email = email;
        this.country = country;
        this.state = state;
    }

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BillingAddress setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
        return this;
    }

    public BillingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public BillingAddress setPostalCode(int postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public BillingAddress setEmail(String email) {
        this.email = email;
        return this;
    }

    public BillingAddress setCountry(String country) {
        this.country = country;
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public String getCity() {
        return city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getEmail() {
        return email;
    }

    public String getState() {return state;}

    public String getCountry() {return country;}

}
