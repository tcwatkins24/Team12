package com.group12.vanPool.data.repository;

import com.group12.vanPool.data.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    @Transactional
    @Modifying
    @Query("update Users set password = :password where uName = :uName" )
    void updatePassword(@Param("uName") String uName,@Param("password") String password);

}
