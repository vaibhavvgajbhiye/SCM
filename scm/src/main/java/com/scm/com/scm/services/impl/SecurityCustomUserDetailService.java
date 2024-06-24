package com.scm.com.scm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scm.com.scm.repositories.UserRepo;

@Service
public class  SecurityCustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    //isme wo code hai jo database se user ko la rahi hai
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    //apne user ko load karna hai
    return userRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found" +username));

    }

    
}