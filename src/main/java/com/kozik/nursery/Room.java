package com.kozik.nursery;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roomID", nullable = false)
    private Integer roomID;
    
    @Column(name = "room_description", nullable = false, length = 60)
    private String roomDescription;

    @ManyToMany(mappedBy = "rooms")
    private Set<Group> groups = new HashSet<Group>();
    
    protected Room(){}

    public Room(String roomDescription) {
        this.roomDescription = roomDescription;
    }
    
    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
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

    @Override
    public String toString() {
        return "Room{" + "roomID=" + roomID + ", roomDescription=" + roomDescription + '}';
    }
}
