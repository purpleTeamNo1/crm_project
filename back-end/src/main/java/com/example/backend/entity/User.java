package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@ToString(exclude = {"role","todoList"})
@Entity
@Table(name = "tbuser")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
@ApiModel
public class User implements Serializable {

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
    @Column(name = "firstname", length = 50, nullable = false)
    private String firstName;

    @ApiModelProperty(required = true)
    @Column(name = "lastname", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", length = 50, nullable = false)
    @ApiModelProperty
    private String email;

    @Column(name = "last_update", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp lastUpdate;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    @ApiModelProperty
    private Role role;

//    @JsonBackReference
//    @OneToMany(targetEntity = Todos.class, fetch = FetchType.LAZY)
//    private List<Todos> todosList;
}
