package com.group12.vanPool.data.entity;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @Column(name = "vNumber")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vNumber;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "vYear")
    private int vYear;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "currentRoute")
    private int currentRoute;


    public int getvNumber() {
        return vNumber;
    }

    public void setvNumber(int vNumber) {
        this.vNumber = vNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getvYear() {
        return vYear;
    }

    public void setvYear(int vYear) {
        this.vYear = vYear;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentRoute() {
        return currentRoute;
    }

    public void setCurrentRoute(int currentRoute) {
        this.currentRoute = currentRoute;
    }

}
