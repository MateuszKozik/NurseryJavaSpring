
package com.kozik.nursery;

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
    private Integer recordID;
    
    @Column(name = "date_of_record", nullable = false)
    private LocalDate dateOfRecord;
    
    @Column(name = "months_number", nullable = false)
    private Integer monthsNumber;
    
    @ManyToOne
    @JoinColumn(name = "groupID", nullable = true)
    private Group group;
    
    @ManyToOne
    @JoinColumn(name = "childID", nullable = false)
    private Child child;
    
    @ManyToOne
    @JoinColumn(name = "feeID", nullable = true)
    private Fee fee;
    
    protected Record(){}

    public Record(LocalDate dateOfRecord, Integer monthsNumber, Child child) {
        this.dateOfRecord = dateOfRecord;
        this.monthsNumber = monthsNumber;   
        this.child = child;
    }
    
    public Integer getRecordID() {
        return recordID;
    }

    public void setRecordID(Integer recordID) {
        this.recordID = recordID;
    }

    public LocalDate getDateOfRecord() {
        return dateOfRecord;
    }

    public void setDateOfRecord(LocalDate dateOfRecord) {
        this.dateOfRecord = dateOfRecord;
    }

    public Integer getMonthsNumber() {
        return monthsNumber;
    }

    public void setMonthsNumber(Integer monthsNumber) {
        this.monthsNumber = monthsNumber;
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
        return "Record{" + "recordID=" + recordID + ", dateOfRecord=" + dateOfRecord.toString() + ", monthsNumber=" + monthsNumber + '}';
    }   
}
