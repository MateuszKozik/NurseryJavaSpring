package com.kozik.nursery.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
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
    
    @OneToMany(mappedBy = "address")
    private Set<Employee> employees = new HashSet<Employee>();
    
    @OneToMany(mappedBy = "address")
    private Set<Parent> parents = new HashSet<Parent>();
    
    public Address(){}

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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Parent> getParents() {
        return parents;
    }

    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "Address{" + "addressID=" + addressID + ", street=" + street + ", houseNumber=" + houseNumber + ", flatNumber=" + flatNumber + ", postcode=" + postcode + ", city=" + city + '}';
    } 
}
