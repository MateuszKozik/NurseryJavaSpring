
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
@Table(name = "groups")   
public class Group {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "groupID", nullable = false)
    private Integer groupID;
    
    @Column(name = "group_description", nullable = false, length = 60)
    private String groupDescription;
    
    @ManyToMany(mappedBy = "groups")
    private Set<Employee> employees = new HashSet<Employee>();
            
    protected Group(){}

    public Group(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
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

    @Override
    public String toString() {
        return "Group{" + "groupID=" + groupID + ", groupDescription=" + groupDescription + '}';
    }
}
