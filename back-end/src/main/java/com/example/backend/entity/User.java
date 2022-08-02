package com.example.backend.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_user")
@ApiModel
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @ApiModelProperty(allowEmptyValue = true)
    private int userId;

    @Column(name = "username", length=50, nullable = false, unique = true)
    @ApiModelProperty(required = true)
    private String username;

    //the verification of password will be done in controller
    @Column(name = "password", length=50, nullable = false)
    @ApiModelProperty(required = true)
    private String password;

    @ApiModelProperty(required = true)
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @ApiModelProperty(required = true)
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", length = 50, nullable = false)
    @ApiModelProperty
    private String email;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    @ApiModelProperty
    private Role role;
}
