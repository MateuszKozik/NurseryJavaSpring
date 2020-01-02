
package com.kozik.nursery.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "childrens")
public class Child {
   
    @Id
    @Column(name = "pesel", nullable = false, length = 11)
    private String pesel;
    
    @Column(name = "name", nullable = false, length = 25)
    private String name;
    
    @Column(name = "surname", nullable = false, length = 25)
    private String surname;
    
    @Column(name = "special_requirements", nullable = true)
    private Boolean specialRequirements;
    
    @Column(name = "requirements_description", nullable = true, length = 60)
    private String requirementsDescription;

    @Column(name = "saved", nullable = false)
    private Boolean saved = false; 
    
    @ManyToMany(mappedBy = "children")
    private Set<Parent> parents = new HashSet<Parent>();
    
    @OneToMany(mappedBy = "child")
    private Set<Record> records = new HashSet<Record>();
    
    public Child(){}

    public Child(String pesel, String name, String surname) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
    }
    
    
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
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

    public Boolean getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirements(Boolean specialRequirements) {
        this.specialRequirements = specialRequirements;
    }

    public String getRequirementsDescription() {
        return requirementsDescription;
    }

    public void setRequirementsDescription(String requirementsDescription) {
        this.requirementsDescription = requirementsDescription;
    }

    public Set<Parent> getParents() {
        return parents;
    }

    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    @Override
    public String toString() {
        return "Child{" + "pesel=" + pesel + ", name=" + name + ", surname=" + surname + ", specialRequirements=" + specialRequirements + ", requirementsDescription=" + requirementsDescription + '}';
    }
}
