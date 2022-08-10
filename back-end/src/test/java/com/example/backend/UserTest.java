package com.example.backend;

import com.example.backend.controller.DTO.LoginDTO;
import com.example.backend.controller.DTO.RegistryDTO;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import com.example.backend.utils.Md5Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void loginTest(){
        LoginDTO loginDTO = userService.login("admin","123456");
        System.out.println(loginDTO);
    }

    @Test
    public void registryTest() throws NoSuchAlgorithmException {
        RegistryDTO registryDTO = new RegistryDTO();
        registryDTO.setUsername("johndoe1");
        registryDTO.setPassword("123456");
        registryDTO.setEmail("johndoe@gmail.com");
        registryDTO.setFirstName("John");
        registryDTO.setLastName("Doe");
        registryDTO.setRoleId(1);
        System.out.println(userService.registry(registryDTO));
    }

    @Test
    public void md5GeneratorTest() throws NoSuchAlgorithmException {
        System.out.println(Md5Utils.md5Generator("test"));
    }

    @Test
    public void findallTest(){
        List<User> all = userService.findAllUser(0,5);
        System.out.println(all);
    }

    @Test
    public void timeStampGenerator(){
        long time = System.currentTimeMillis();
        System.out.println(new Timestamp(time));
    }
}
