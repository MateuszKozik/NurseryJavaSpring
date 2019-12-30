package com.kozik.nursery.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roomID", nullable = false)
    private Long roomID;
    
    @Column(name = "room_description", nullable = false, length = 60)
    private String roomDescription;

    @ManyToMany(mappedBy = "rooms")
    private Set<Group> groups = new HashSet<Group>();
    
    @ManyToMany(mappedBy = "rooms")
    private Set<Employee> employees = new HashSet<Employee>();
    
    @OneToMany(mappedBy = "room")
    private Set<Item> items = new HashSet<Item>();
    
    public Room(){}

    public Room(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Room{" + "roomID=" + roomID + ", roomDescription=" + roomDescription + '}';
    }
}
