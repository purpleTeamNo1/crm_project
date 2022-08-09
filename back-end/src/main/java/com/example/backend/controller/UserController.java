package com.example.backend.controller;

import com.example.backend.common.Result;
import com.example.backend.controller.DTO.LoginDTO;
import com.example.backend.controller.DTO.RegistryDTO;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import com.example.backend.utils.Md5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "user-controller")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("login")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "username", required = true, paramType = "query"),
//            @ApiImplicitParam(name = "password", required = true, paramType = "query")
//    })
    public Result login(@RequestBody LoginDTO loginDTO) throws NoSuchAlgorithmException {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return Result.error();
        }
        String passwordMd5 = Md5Utils.md5Generator(password);
        LoginDTO dtoReturn = userService.login(username,passwordMd5);
        return Result.success(dtoReturn);
    }

    @PostMapping("/Registry")
    @ApiOperation("Registry")
    public Result registry(@RequestBody RegistryDTO registryDTO) throws NoSuchAlgorithmException {
        return userService.registry(registryDTO);
    }

    @GetMapping("/findall")
    @ApiOperation(("find all user, sort by id asc"))
    public List<User> findAll(@RequestParam int page,
                              @RequestParam int size){
        return userService.findAllUser(page,size);
    }

    @DeleteMapping("/delete")
    @ApiOperation("Delete user by id")
    public void deleteUser(@RequestParam int id){
        userService.deleteUser(id);
    }// better to return a Result object
}
