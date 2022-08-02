package com.example.backend.controller.DTO;

import lombok.Data;

@Data
public class RegistryDTO {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String LastName;
    private int roleId;
}
