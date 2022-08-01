package com.example.backend.controller.DTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String token;
}
