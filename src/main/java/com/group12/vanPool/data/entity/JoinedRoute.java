package com.group12.vanPool.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JoinedRoute")
public class JoinedRoute {
    public JoinedRoute(){}

    public JoinedRoute(int r_id) {

        this.routeID = r_id;
    }

    @Id
    @Column(name="routeID")
    private int routeID;

    public int getId() {return this.routeID;}
}
