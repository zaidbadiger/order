package com.clothingfly.order.Model;


public class Address {
    private String firstName;
    private String lastName;
    private String address;
    private String country;
    private String apartmentNo;
    private String state;
    private String city;
    private String zipcode;
    public Address(String firstName, String lastName, String address, String country, String apartmentNo, String state,
            String city, String zipcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        this.apartmentNo = apartmentNo;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getApartmentNo() {
        return apartmentNo;
    }
    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    
}
