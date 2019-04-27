package com.group12.vanPool.business.service;

import com.group12.vanPool.data.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> getUsers();

    Users getByUsername(String uname);

    int getUserType(String uname);

    Boolean checkIfUserExists(String uname);

}
