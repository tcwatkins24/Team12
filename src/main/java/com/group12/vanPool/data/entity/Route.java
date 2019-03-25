package com.group12.vanPool.data.entity;

import javax.persistence.*;

@Entity
public class Route {

    @Column(name = "rNumber")
    private int rNumber;
    @Column(name = "startLoc")
    private String startLoc;
    @Column(name = "endLoc")
    private String endLoc;

    public int getrNumber() {
        return rNumber;
    }
    public void setrNumber(int rNum){
        this.rNumber = rNum;
    }

    public String getStartLoc() {
        return this.startLoc;
    }
    public void setStartLoc(String sLoc) {
        this.startLoc = sLoc;
    }

    public String getEndLoc() {
        return endLoc;
    }
    public void setEndLoc(String endLoc) {
        this.endLoc = endLoc;
    }
}
