package com.example.backend.controller;

import com.example.backend.common.Result;
import com.example.backend.controller.DTO.UserDTO;
import com.example.backend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "the controller related to user operation, such as login, register, password reset and so on")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", required = true, paramType = "query")
    })
    public Result login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password){
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return Result.error();
        }
        UserDTO userDTO = userService.login(username,password);
        return Result.success(userDTO);
    }
}
