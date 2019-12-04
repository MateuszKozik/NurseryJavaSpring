package com.kozik.nursery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressID", nullable = false)
    private Integer addressID;
    
    @Column(name = "street", nullable = true, length = 35)
    private String street;
    
    @Column(name = "house_number", nullable = false)
    private Integer houseNumber;
    
    @Column(name = "flat_number", nullable = true)
    private Integer flatNumber;
    
    @Column(name = "postcode", nullable = false, length = 6)
    private String postcode;
    
    @Column(name = "city", nullable = false, length = 35)
    private String city;
    
    protected Address(){}

    public Address(Integer houseNumber, String postcode, String city) {
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.city = city;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" + "addressID=" + addressID + ", street=" + street + ", houseNumber=" + houseNumber + ", flatNumber=" + flatNumber + ", postcode=" + postcode + ", city=" + city + '}';
    } 
}
