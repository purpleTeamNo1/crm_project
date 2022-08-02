package com.example.backend;

import com.example.backend.controller.DTO.UserDTO;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import com.example.backend.utils.Md5Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;

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
        user.setUsername("johndoe1");
        user.setPassword("123456");
        user.setEmail("johndoe@gmail.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        System.out.println(userService.registry(user));
    }

    @Test
    public void md5GeneratorTest() throws NoSuchAlgorithmException {
        System.out.println(Md5Utils.md5Generator("test"));
    }
}
