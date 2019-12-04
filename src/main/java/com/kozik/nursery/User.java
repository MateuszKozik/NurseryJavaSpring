
package com.kozik.nursery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userID", nullable = false)
    private Integer userID;
    
    @Column(name = "username", nullable = false, length = 25, unique = true)
    private String userName;
    
    @Column(name = "password", nullable = false, length = 60)
    private String password;
    
    @Column(name = "email", nullable = false, length = 35)
    private String email;
    
    @Column(name = "roles", nullable = false, length = 25)
    private String roles = "USER";
    
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true; 

    @OneToOne(mappedBy = "user")
    private Employee employee;
    
    @OneToOne(mappedBy = "user")
    private Parent parent;
    
    protected User(){}
    
       public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
       
    public User(String userName, String password, String email, String roles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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
      
    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", userName=" + userName + ", password=" + password + ", email=" + email + ", roles=" + roles + ", enabled=" + enabled.toString() + '}';
    }
    
  
    
    
}
