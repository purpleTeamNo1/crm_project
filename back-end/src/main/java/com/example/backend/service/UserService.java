package com.example.backend.service;

import com.example.backend.controller.DTO.UserDTO;
import com.example.backend.entity.User;

public interface UserService {

    UserDTO login(String username, String password);

    void registry(User user);
}
