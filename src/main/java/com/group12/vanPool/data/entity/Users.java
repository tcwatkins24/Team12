package com.group12.vanPool.data.entity;


import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class Users {


    public Users() {
    }

    public Users(String uName, String password, int currentUserType, int remainingSignInAttempts) {
        this.uName = uName;
        this.password = password;
        this.currentUserType = currentUserType;
        this.remainingSignInAttempts = remainingSignInAttempts;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "uName")
    private String uName;

    @Column(name = "password")
    private String password;

    @Column(name = "currentUserType")
    private int currentUserType;

    @Column(name = "remainingSignInAttempts")
    private int remainingSignInAttempts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCurrentUserType() {
        return currentUserType;
    }

    public void setCurrentUserType(int currentUserType) {
        this.currentUserType = currentUserType;
    }

    public int getRemainingSignInAttempts() {
        return remainingSignInAttempts;
    }

    public void setRemainingSignInAttempts(int remainingSignInAttempts) {
        this.remainingSignInAttempts = remainingSignInAttempts;
    }
}
