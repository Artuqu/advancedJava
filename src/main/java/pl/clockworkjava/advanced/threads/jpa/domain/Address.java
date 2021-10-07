package pl.clockworkjava.advanced.threads.jpa.domain;

import javax.persistence.Embeddable;


@Embeddable
public class Address {


    private String street;
    private String postalCode;
    private String apartment;
    private String city;

    public Address(String street, String postalCode, String apartment, String city) {
        this.street = street;
        this.postalCode = postalCode;
        this.apartment = apartment;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", apartment='" + apartment + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
