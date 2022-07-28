package com.example.backend.service;

import com.example.backend.entity.User;


public interface UserService {
    User findUserByUsername(String username);
}
