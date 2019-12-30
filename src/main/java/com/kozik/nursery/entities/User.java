package com.kozik.nursery.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @Column(name = "email", nullable = false, length = 35)
    private String email;
    
    @Column(name = "userID", columnDefinition = "serial", insertable = false)
    private Integer userID;

    @Column(name = "password", nullable = false, length = 60)
    private String password;
    
    @Column(name = "retyped_password", nullable = false, length = 60)
    private String retypePassword;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true; 

    @OneToOne(mappedBy = "user")
    private Employee employee;
    
    @OneToOne(mappedBy = "user")
    private Parent parent;
    
    protected User(){}
    
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }
      
    
    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", password=" + password + ", email=" + email + ", enabled=" + enabled.toString() + '}';
    }  
}
