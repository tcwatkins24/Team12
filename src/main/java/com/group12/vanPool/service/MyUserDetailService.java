package com.group12.vanPool.service;

import com.group12.vanPool.business.service.UserServiceImplemented;
import com.group12.vanPool.data.entity.Users;
import com.group12.vanPool.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
@Transactional
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserServiceImplemented uservice;

    @Override
    public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {
        Users user = this.uservice.getByUsername(uname);
        if (user == null) return null;

        UserDetails uDetails =
            User.withDefaultPasswordEncoder().username(user.getuName()).password(user.getPassword()).roles("USER").build();

        return uDetails;
    }
}
