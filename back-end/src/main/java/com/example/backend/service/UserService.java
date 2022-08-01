package com.example.backend.service;

import com.example.backend.controller.DTO.UserDTO;

public interface UserService {

    UserDTO login(String username, String password);
}
