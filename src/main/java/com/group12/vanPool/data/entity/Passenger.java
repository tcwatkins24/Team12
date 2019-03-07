package com.group12.vanPool.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "Passenger")
public class Passenger {



    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "pName")
    private String pName;
    @Column(name = "balance")
    private int balance;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public String getpName() {
        return pName;
    }

    public int getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
