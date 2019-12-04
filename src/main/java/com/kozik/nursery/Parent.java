package com.kozik.nursery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parent")
public class Parent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parentID", nullable = false)
    Integer parentID;
    
    @Column(name = "name", nullable = false, length = 25)
    String name;
    
    @Column(name = "surname", nullable = false, length = 25)
    String surname;
    
    @Column(name = "phone_number", nullable = false, length = 9)
    String phoneNumber;
    
    protected Parent(){}

    public Parent(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Parent{" + "parentID=" + parentID + ", name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber + '}';
    }
}
