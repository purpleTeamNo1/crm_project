package com.example.backend.service;

import com.example.backend.common.Result;
import com.example.backend.controller.DTO.LoginDTO;
import com.example.backend.controller.DTO.RegistryDTO;
import com.example.backend.entity.User;

import java.security.NoSuchAlgorithmException;

public interface UserService {

    LoginDTO login(String username, String password);

    Result registry(RegistryDTO registryDTO) throws NoSuchAlgorithmException;
}
