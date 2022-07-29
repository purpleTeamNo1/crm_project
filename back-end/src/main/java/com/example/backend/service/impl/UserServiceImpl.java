package com.example.backend.service.impl;

import com.example.backend.controller.DTO.UserDTO;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public UserDTO login(String username, String password){
        UserDTO userDTO = new UserDTO();
        User user = userRepository.findUserByUsername(username);
        if(user != null){
            BeanUtils.copyProperties(user,userDTO);
//            String token =

        }
        return userDTO;
    }
}
