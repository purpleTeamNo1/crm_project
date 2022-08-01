package com.example.backend;

import com.example.backend.controller.DTO.UserDTO;
import com.example.backend.entity.User;
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
        UserDTO userDTO = userService.login("admin","123456");
        System.out.println(userDTO);
    }

    @Test
    public void registryTest(){
        User user = new User();
        user.setUsername("johndoe");
        user.setPassword("123456");
        user.setEmail("johndoe@gmail.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        userService.registry(user);
    }
}
