package com.example.springjpa.Repositories;

import com.example.springjpa.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.messaging.simp.annotation.SendToUser;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{
    public List<User> findByEmail(String email);
}