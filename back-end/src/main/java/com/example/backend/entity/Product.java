package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "productid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToMany(targetEntity = ClientProduct.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private int productId;

    @Column(name = "productcode")
    private String productCode;

    @Column(name="last_update", columnDefinition = "TIMESTAMP, DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdate;

    @JsonManagedReference
    @OneToOne(targetEntity = Insurance.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "insuranceid")
    private Insurance insurance;

}
