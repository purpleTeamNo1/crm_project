package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@ToString(exclude = {"users"})
@Entity
@Table(name = "tb_role")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "roleId")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name", length=50, nullable = false, unique = true)
    private String roleName;

    @Column(name = "perms", nullable = false)
    private String perms;

    @JsonBackReference
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;

//    @JsonBackReference
//    public List<User> getUsers(){
//        return users;
//    }
}
