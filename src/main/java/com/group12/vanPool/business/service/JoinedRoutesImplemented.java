package com.group12.vanPool.business.service;

import com.group12.vanPool.data.entity.JoinedRoute;
import com.group12.vanPool.data.entity.Route;
import com.group12.vanPool.data.repository.JoinedRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoinedRoutesImplemented implements JoinedRoutesService{

    private final JoinedRoutes joinedRoutes;
    @Autowired
    public JoinedRoutesImplemented(JoinedRoutes joinedRoutes) {this.joinedRoutes = joinedRoutes;}

    @Override
    public List<JoinedRoute> getJoinedRoutes() {
        Iterable<JoinedRoute> jRoutes = this.joinedRoutes.findAll();
        List<JoinedRoute> list = new ArrayList<>();
        for (JoinedRoute r : jRoutes) {
            list.add(r);
        }
        return list;
    }
}
