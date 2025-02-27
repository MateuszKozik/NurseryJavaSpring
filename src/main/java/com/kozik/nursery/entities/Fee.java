package com.kozik.nursery.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fees")
public class Fee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feeID", nullable = false)
    private Long feeID;
    
    @Column(name = "tuition", nullable = false)
    private Double tuition;
    
    @Column(name = "meals", nullable = false)
    private Double meals;
    
    @Column(name = "update_date", nullable = false)
    private LocalDate updateDate;

    @OneToMany(mappedBy = "fee")
    private Set<Record> records = new HashSet<Record>();
    
    public Fee(){}

    public Fee(Double tuition, Double meals, LocalDate updateDate) {
        this.tuition = tuition;
        this.meals = meals;
        this.updateDate = updateDate;
    }

    public Long getFeeID() {
        return feeID;
    }

    public void setFeeID(Long feeID) {
        this.feeID = feeID;
    }
    
    public Double getTuition() {
        return tuition;
    }

    public void setTuition(Double tuition) {
        this.tuition = tuition;
    }

    public Double getMeals() {
        return meals;
    }

    public void setMeals(Double meals) {
        this.meals = meals;
    }

    public String getUpdateDate() {
         if (updateDate != null) {
            return updateDate.toString();
        } else {
            return "";
        }
    }

    public void setUpdateDate(String updateDate) {
        LocalDate date = LocalDate.parse(updateDate, DateTimeFormatter.ISO_LOCAL_DATE);
        this.updateDate = date;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Fee{" + "feeID=" + feeID + ", tuition=" + tuition + ", meals=" + meals + ", updateDate=" + updateDate.toString() + '}';
    }  
}
