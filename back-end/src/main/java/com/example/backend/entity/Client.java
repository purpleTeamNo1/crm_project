package com.example.backend.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Data
@ToString(exclude = {})
@Entity
@Table(name = "tb_client")
@ApiModel
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    @ApiModelProperty(allowEmptyValue = true)
    private int clientId;

    @Column(name = "status", nullable = false)
    private int status = 2;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "home_phone", length = 10)
    private String homePhone;

    @Column(name = "cell_phone", length = 10)
    private String cellPhone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "postal_code", length = 7, nullable = false)
    private String postalCode;

    @Column(name = "SIN", length = 9)
    private String sin;

    @Column(name = "gender", length = 50, nullable = false)
    private String gender;

    @Column(name = "marital_status", length = 20, nullable = false)
    private String maritalStatus;

    @Column(name = "citizenship", length = 50, nullable = false)
    private String citizenship;

    @Column(name = "source", length = 50, nullable = false)
    private String source;


}
