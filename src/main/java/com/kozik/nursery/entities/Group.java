package com.kozik.nursery.entities;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groups")   
public class Group {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "groupID", nullable = false)
    private Long groupID;
    
    @Column(name = "group_description", nullable = false, length = 60)
    private String groupDescription;
    
    @ManyToMany
    @JoinTable(
            name = "employees_groups",
            joinColumns = @JoinColumn(name = "groupID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "employeeID", nullable = false))
    private Set<Employee> employees = new HashSet<Employee>();
      
    @OneToMany(mappedBy = "group")
    private Set<Record> records = new HashSet<Record>();
    
    @ManyToMany
    @JoinTable(
            name = "groups_rooms",
            joinColumns = @JoinColumn(name = "groupID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "roomID", nullable = false))
    private Set<Room> rooms = new HashSet<Room>();
    
    public Group(){}

    public Group(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Group{" + "groupID=" + groupID + ", groupDescription=" + groupDescription + '}';
    }
}
