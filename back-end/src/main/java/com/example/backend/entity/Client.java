package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@ToString(exclude = {})
@Entity
@Table(name = "client")
@ApiModel
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    @ApiModelProperty(allowEmptyValue = true)
    private int clientId;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "firstname", length = 50)
    private String firstname;

    @Column(name = "lastname", length = 50)
    private String lastName;

    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @Column(name = "age")
    private int age;

    @Column(name = "homephone", length = 10)
    private String homePhone;

    @Column(name = "cellphone", length = 10)
    private String cellPhone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "postalcode", length = 7)
    private String postalCode;

    @Column(name = "SIN", length = 9)
    private String sin;

    @Column(name = "gender", length = 50)
    private String gender;

    @Column(name = "maritalstatus", length = 20)
    private String maritalStatus;

    @Column(name = "citizenship", length = 50)
    private String citizenship;

    @Column(name = "source", length = 50)
    private String source;

    @Column(name = "referredby", length = 50)
    private String referredBy;

    @Column(name = "giftgiven")
    private boolean giftGiven;

    @Column(name = "planid", length = 50)
    private String planId;

    @Column(name = "segfundnum", length = 50)
    private String segfundNum;

    @Column(name = "wechatid", length = 50)
    private String wechatId;

    @Column(name = "linkedinid", length = 50)
    private String linkedinId;

    @Column(name = "facebookid", length = 50)
    private String facebookId;

    @Column(name = "twitterid", length = 50)
    private String twitterId;

    @Column(name = "instagramid", length = 50)
    private String instagramId;

    @Column(name = "last_update", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdate;

    @JsonBackReference
    @OneToMany(mappedBy = "client",  fetch = FetchType.LAZY)
    private List<Todos> todosList;

    @ManyToMany(targetEntity = Product.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "clientproduct",
    joinColumns = {@JoinColumn(name = "sys_client_id",referencedColumnName = "client_id")},
    inverseJoinColumns = {@JoinColumn(name = "sys_product_id", referencedColumnName = "productid")})
    private List<Product> productList;
}
