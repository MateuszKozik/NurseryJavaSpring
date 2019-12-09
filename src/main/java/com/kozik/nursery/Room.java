package com.kozik.nursery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
