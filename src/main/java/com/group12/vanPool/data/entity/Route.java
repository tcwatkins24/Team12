package com.group12.vanPool.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "ROUTE")
public class Route {

    public Route() {
    }

    public Route(String startLoc, String endLoc, String startPickUpTime, String endPickUpTime, int capacity) {
        this.startLoc = startLoc;
        this.endLoc = endLoc;
        this.startPickUpTime = startPickUpTime;
        this.endPickUpTime = endPickUpTime;
        this.capacity = capacity;
        this.cost = 12.50;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String startLoc;
    private String endLoc;
    private String startPickUpTime;
    private String endPickUpTime;
    private int capacity;
    private double cost;

    public double getCost() {return this.cost;}

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStartPickUpTime() {
        return startPickUpTime;
    }

    public void setStartPickUpTime(String startPickUpTime) {
        this.startPickUpTime = startPickUpTime;
    }

    public String getEndPickUpTime() {
        return endPickUpTime;
    }

    public void setEndPickUpTime(String endPickUpTime) {
        this.endPickUpTime = endPickUpTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartLoc() {
        return startLoc;
    }

    public void setStartLoc(String startLoc) {
        this.startLoc = startLoc;
    }

    public String getEndLoc() {
        return endLoc;
    }

    public void setEndLoc(String endLoc) {
        this.endLoc = endLoc;
    }
}
