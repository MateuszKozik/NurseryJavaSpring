package com.kozik.nursery.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "records")
public class Record {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recordID", nullable = false)
    private Long recordID;
    
    @Column(name = "date_of_record", nullable = false)
    private LocalDate dateOfRecord;
    
    @ManyToOne
    @JoinColumn(name = "groupID", nullable = true)
    private Group group;
    
    @ManyToOne
    @JoinColumn(name = "childID", nullable = false)
    private Child child;
    
    @ManyToOne
    @JoinColumn(name = "feeID", nullable = true)
    private Fee fee;
    
    public Record(){}

    public Long getRecordID() {
        return recordID;
    }

    public void setRecordID(Long recordID) {
        this.recordID = recordID;
    }
   
    public LocalDate getDateOfRecord() {
        return dateOfRecord;
    }

    public void setDateOfRecord(LocalDate dateOfRecord) {
        this.dateOfRecord = dateOfRecord;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Record{" + "recordID=" + recordID + ", dateOfRecord=" + dateOfRecord.toString() + "}";
    }   
}
