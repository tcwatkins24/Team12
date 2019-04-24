package com.group12.vanPool.data.entity;

import javax.persistence.*;

@Entity
@Table(name="Driver")
public class Driver {

    public Driver() {
    }

    public Driver(String dName, int route, String username, boolean isAuth) {
        this.dName = dName;
        this.route = route;
        this.username = username;
        this.isAuth = isAuth;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "dName")
    private String dName;
    @Column(name = "route")
    private int route;
    @Column(name = "username")
    private String username;
    @Column(name = "isAuth")
    private boolean isAuth = false;


    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getdName() {
        return this.dName;
    }
    public void setdName(String name) {
        this.dName = name;
    }

    public int getRoute() {return this.route;}
    public void setRoute(int r) {this.route = r;}

    public String getUsername() {return this.username;}
    public void setUsername(String username) {this.username = username;}

    public boolean getAuth() {return this.isAuth;}
    public void setAuth(boolean flag) {this.isAuth = flag;}

}
