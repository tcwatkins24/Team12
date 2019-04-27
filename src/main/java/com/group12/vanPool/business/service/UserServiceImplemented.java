package com.group12.vanPool.business.service;

import com.group12.vanPool.data.entity.Users;
import com.group12.vanPool.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplemented implements UserService{

    private final UserRepository userRepo;

    @Autowired
    public UserServiceImplemented(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<Users> getUsers() {
        Iterable<Users> users = this.userRepo.findAll();
        List<Users> list = new ArrayList<>();
        for( Users user : users) {
            list.add(user);
        }
        return list;
    }

    @Override
    public Users getByUsername(String uname) {
        Iterable<Users> users = this.userRepo.findAll();
        for(Users user : users) {
            if (user.getuName().equals(uname)){
                return user;
            }
        }

        throw new UsernameNotFoundException("Could not find username: "+ uname);
    }

    @Override
    public int getUserType(String uname) {
        Iterable<Users> users = this.userRepo.findAll();
        for(Users user : users) {
            if (user.getuName().equals(uname)){
                return user.getCurrentUserType();
            }
        }

        throw new UsernameNotFoundException("Could not find username: "+ uname);
    }

    @Override
    public Boolean checkIfUserExists(String uname) {

        Iterable<Users> users = this.userRepo.findAll();
        for (Users user : users) {
            if (user.getuName().equals(uname)) {
                return true;
            }
        }
        return false;
    }
}
