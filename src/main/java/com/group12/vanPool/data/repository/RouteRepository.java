package com.group12.vanPool.data.repository;

import com.group12.vanPool.data.entity.Route;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface RouteRepository extends CrudRepository<Route, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update Route r set r.capacity = ? where r.id= ?",
            nativeQuery = true)
    int updateCapacity(Integer capacity, Integer r_id);

}
