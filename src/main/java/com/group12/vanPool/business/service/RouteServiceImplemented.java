package com.group12.vanPool.business.service;

import com.group12.vanPool.data.entity.Route;
import com.group12.vanPool.data.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImplemented implements RouteService{


    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImplemented(RouteRepository routeRepository){
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Route> getRides() {
        Iterable<Route> routes = this.routeRepository.findAll();
        List<Route> list = new ArrayList<>();
        for(Route route :routes
             ) {
            list.add(route);
        }
        return list;
    }
}
