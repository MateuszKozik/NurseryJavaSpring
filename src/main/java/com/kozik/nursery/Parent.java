package com.kozik.nursery;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parents")
public class Parent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parentID", nullable = false)
    private Integer parentID;
    
    @Column(name = "name", nullable = false, length = 25)
    private String name;
    
    @Column(name = "surname", nullable = false, length = 25)
    private String surname;
    
    @Column(name = "phone_number", nullable = false, length = 9)
    private String phoneNumber;
    
    @OneToOne
    @JoinColumn(name = "userID", nullable = false, unique = true)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "addressID", nullable = true)
    private Address address;
    
    @ManyToMany
    @JoinTable(
            name = "parent_children",
            joinColumns = @JoinColumn(name = "parentID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "pesel", nullable = false))
    private Set<Child> children = new HashSet<Child>();
    
    protected Parent(){}

    public Parent(String name, String surname, String phoneNumber, User user) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Parent{" + "parentID=" + parentID + ", name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber + '}';
    }
}
