package com.rest.webservices.restfulwebservices.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user_login")
public class UserLogin {

    @Id
    private int id;

    private String userName;
    private String password;
    private String emailId;

    public UserLogin(){

    }
    public UserLogin(int id, String userName, String password, String emailId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
