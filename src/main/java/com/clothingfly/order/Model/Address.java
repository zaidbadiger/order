package com.clothingfly.order.Model;
import javax.persistence.*;
@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "address")
  private String address;

  @Column(name = "country")
  private String country;

  @Column(name = "apartmentNo")
  private String apartmentNo;

  @Column(name = "state")
  private String state;

  @Column(name = "city")
  private String city;

  @Column(name = "zipcode")
  private String zipcode;


  public Address() {

  }

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
