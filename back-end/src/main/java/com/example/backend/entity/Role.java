package com.example.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name", length=50, nullable = false, unique = true)
    private String roleName;

    @Column(name = "perms", nullable = false)
    private String perms;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
//    @JoinColumn(name = "role_id")
    private List<User> users;
}
