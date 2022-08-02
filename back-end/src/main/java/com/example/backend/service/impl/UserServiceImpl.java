package com.example.backend.service.impl;

import com.example.backend.common.Constants;
import com.example.backend.controller.DTO.UserDTO;
import com.example.backend.entity.User;
import com.example.backend.exception.ServiceException;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;
import com.example.backend.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO login(String username, String password){
        UserDTO userDTO = new UserDTO();
        User user = userRepository.findUserByUsername(username);
        //If the password is encoded by MD5, here should use md5 to encode the password as well

        if(user != null && user.getPassword().equals(password)){
            userDTO.setUsername(username);
            String role = user.getRole().getRoleName();
            String token = TokenUtils.createToken(username,role);
            userDTO.setToken(token);
            return userDTO;
        }else {
            throw new ServiceException(Constants.CODE_600, "Username or password is wrong");
        }
    }

    public boolean registry(User user){
        return userRepository.save(user)!=null?true:false;
    }
}
