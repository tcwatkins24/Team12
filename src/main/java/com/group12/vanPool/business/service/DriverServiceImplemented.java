package com.group12.vanPool.business.service;

import com.group12.vanPool.data.entity.Driver;
import com.group12.vanPool.data.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImplemented implements DriverService{

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImplemented(DriverRepository dr) {
        this.driverRepository = dr;
    }

    @Override
    public List<Driver> getDrivers() {
        Iterable<Driver> drivers = this.driverRepository.findAll();
        List<Driver> list = new ArrayList<>();
        for (Driver d : drivers) {
            list.add(d);
        }
        return list;
    }

    @Override
    public List<Driver> getUnvalidatedDrivers() {
        Iterable<Driver> drivers = this.driverRepository.findAll();
        List<Driver> list = new ArrayList<>();
        for (Driver d : drivers) {
            if(d.getAuth() == false){
                list.add(d);
            }
        }
        return list;
    }
}
