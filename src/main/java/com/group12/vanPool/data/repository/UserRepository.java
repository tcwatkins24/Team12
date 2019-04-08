package com.group12.vanPool.data.repository;

import com.group12.vanPool.data.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
}
