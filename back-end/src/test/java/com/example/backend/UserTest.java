package com.example.backend;

import com.example.backend.controller.DTO.UserDTO;
import com.example.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void loginTest(){
        UserDTO userDTO = new UserDTO();
        userDTO = userService.login("admin","123456");
        System.out.println(userDTO);
    }
}
