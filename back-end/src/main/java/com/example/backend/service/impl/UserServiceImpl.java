package com.example.backend.service.impl;

import com.example.backend.common.Constants;
import com.example.backend.common.Result;
import com.example.backend.controller.DTO.LoginDTO;
import com.example.backend.controller.DTO.RegistryDTO;
import com.example.backend.entity.Role;
import com.example.backend.entity.User;
import com.example.backend.exception.ServiceException;
import com.example.backend.repository.RoleRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;
import com.example.backend.utils.DateAndTimeUtils;
import com.example.backend.utils.Md5Utils;
import com.example.backend.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public LoginDTO login(String username, String password){
        LoginDTO loginDTO = new LoginDTO();
        User user = userRepository.findUserByUsername(username);
        //If the password is encoded by MD5, here should use md5 to encode the password as well

        if(user != null && user.getPassword().equals(password)){
            loginDTO.setUsername(username);
            String role = user.getRole().getRoleName();
            String token = TokenUtils.createToken(username,role);
            loginDTO.setToken(token);
            return loginDTO;
        }else {
            throw new ServiceException(Constants.CODE_600, "Username or password is wrong");
        }
    }

    public Result registry(RegistryDTO registryDTO) throws NoSuchAlgorithmException {

        User userCheck = userRepository.findUserByUsername(registryDTO.getUsername());
        if(userCheck != null){
            return Result.error("600","The user has existed!");
        }
        User user = new User();
        String passwordMd5 = Md5Utils.md5Generator(registryDTO.getPassword());
        registryDTO.setPassword(passwordMd5);
        BeanUtils.copyProperties(registryDTO, user);
        user.setLastUpdate(DateAndTimeUtils.getCurrentTime());

        Role role = roleRepository.findRoleByRoleId(registryDTO.getRoleId());
        if(role == null){
            return Result.error("500", "Assigned role does not exist.");
        }
        user.setRole(role);
        userRepository.save(user);
        return Result.success("New user has been added!");
    }

    public List<User> findAllUser(int page, int size){
        List all = userRepository.findAll(PageRequest.of(page,size, Sort.by("userId").ascending())).get().toList();
        return all;
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
