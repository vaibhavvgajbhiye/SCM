package com.scm.com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.com.scm.entities.User;
import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User,String>{
    // extra methods db relatedoperations
    //custom queries methods
    //custom finder meethods
    
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}
