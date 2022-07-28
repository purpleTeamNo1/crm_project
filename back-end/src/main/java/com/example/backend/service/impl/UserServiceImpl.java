package com.example.backend.service.impl;

import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public User findUserbyname(String username){
        return userRepository.findUserByUsername(username);
    }
}
