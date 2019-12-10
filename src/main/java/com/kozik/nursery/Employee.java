package com.kozik.nursery;

import java.time.LocalDate;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity()
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emplyeeID", nullable = false)
    private Integer emplyeeID;
    
    @Column(name = "name", nullable = false, length = 25)
    private String name;
    
    @Column(name = "surname", nullable = false, length = 25)
    private String surname;
    
    @Column(name = "employment_date", nullable = false)
    private LocalDate emplymentDate;
    
    @Column(name = "phone_number", nullable = false, length = 9)
    private String phoneNumber;
    
    @Column(name = "position", nullable = true, length = 25)
    private String position;
    
    @Column(name = "base_salary", nullable = true)
    private Double baseSalary;
    
    @Column(name = "extra_pay", nullable = true)
    private Double extraPay;
    
    @ManyToOne
    @JoinColumn(name = "supervisor", nullable = true)
    private Employee supervisor;
    
    @OneToMany(mappedBy = "supervisor")
    private Set<Employee> subordinates = new HashSet<Employee>();
    
    @OneToOne
    @JoinColumn(name = "userID", nullable = false, unique = true)
    private User user;          
    
    @ManyToOne
    @JoinColumn(name = "addressID", nullable = true)
    private Address address;
    
    @ManyToMany
    @JoinTable(
            name = "employees_groups",
            joinColumns = @JoinColumn(name = "employeeID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "groupID", nullable = false))
    private Set<Group> groups = new HashSet<Group>();
    
    @ManyToMany
    @JoinTable(
            name = "employees_rooms",
            joinColumns = @JoinColumn(name = "employeeID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "roomID", nullable = false))
    private Set<Room> rooms = new HashSet<Room>();
    
    protected Employee(){}

    public Employee(String name, String surname, LocalDate emplymentDate, String phoneNumber, User user) {
        this.name = name;
        this.surname = surname;
        this.emplymentDate = emplymentDate;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }
    
    
    public Integer getEmplyeeID() {
        return emplyeeID;
    }

    public void setEmplyeeID(Integer emplyeeID) {
        this.emplyeeID = emplyeeID;
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

    public LocalDate getEmplymentDate() {
        return emplymentDate;
    }

    public void setEmplymentDate(LocalDate emplymentDate) {
        this.emplymentDate = emplymentDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getExtraPay() {
        return extraPay;
    }

    public void setExtraPay(Double extraPay) {
        this.extraPay = extraPay;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
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

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Employee{" + "emplyeeID=" + emplyeeID + ", name=" + name + ", surname=" + surname + ", emplymentDate=" + emplymentDate.toString() + ", phoneNumber=" + phoneNumber + ", position=" + position + ", baseSalary=" + baseSalary + ", extraPay=" + extraPay+"}";
    }
    
    
}
