package com.example.backend.controller.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Data
public class ClientDTO {

    @ApiModelProperty(required = true)
    private int clientId=0;

    @ApiModelProperty(required = true)
    private int status = 2;

    @ApiModelProperty
    private String firstname;

    @ApiModelProperty
    @Column(name = "lastname", length = 50)
    private String lastName;

    @ApiModelProperty
    private Date dateOfBirth;

    @ApiModelProperty
    private int age;

    @ApiModelProperty
    private String homePhone;

    @ApiModelProperty
    private String cellPhone;

    @ApiModelProperty
    private String email;

    @ApiModelProperty
    private String address;

    @ApiModelProperty
    private String postalCode;

    @ApiModelProperty
    private String sin;

    @ApiModelProperty
    private String gender;

    @ApiModelProperty
    private String maritalStatus;

    @ApiModelProperty
    private String citizenship;

    @ApiModelProperty
    private String source;

    @ApiModelProperty
    private String referredBy;

    @ApiModelProperty
    private boolean giftGiven;

    @ApiModelProperty
    private String planId;

    @ApiModelProperty
    private String segfundNum;

    @ApiModelProperty
    private String wechatId;

    @ApiModelProperty
    private String linkedinId;

    @ApiModelProperty
    private String facebookId;

    @ApiModelProperty
    private String twitterId;

    @ApiModelProperty
    private String instagramId;

}
