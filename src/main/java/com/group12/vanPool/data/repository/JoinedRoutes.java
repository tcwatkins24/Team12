package com.group12.vanPool.data.repository;

import com.group12.vanPool.data.entity.JoinedRoute;
import com.group12.vanPool.data.entity.Route;
import org.springframework.data.repository.CrudRepository;

public interface JoinedRoutes extends CrudRepository<JoinedRoute, Integer> {

}
