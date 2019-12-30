package com.kozik.nursery.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
    
    @Id
    @Column(name = "inventory_number", nullable = false)
    private Long inventoryNumber;
    
    @Column(name = "item_name", nullable = false, length = 25)
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "roomID", nullable = true)
    private Room room;
    
    public Item(){}

    public Item(Long inventoryNumber, String itemName) {
        this.inventoryNumber = inventoryNumber;
        this.itemName = itemName;
    }

    public Long getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Long inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Item{" + "inventoryNumber=" + inventoryNumber + ", itemName=" + itemName + '}';
    } 
}
