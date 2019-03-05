package com.group12.vanPool.data.entity;

import javax.persistence.*;

@Entity
@Table(name="Driver")
public class Driver {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "dName")
    private String dName;

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

}
