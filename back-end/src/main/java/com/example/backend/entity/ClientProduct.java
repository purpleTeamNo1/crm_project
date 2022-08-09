package com.example.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "clientproduct")
@ToString(exclude = {"client","product"})
//@IdClass(ClientProductID.class)
public class ClientProduct implements Serializable{
    @Id
    @Column(name = "sys_client_id")
    private int clientId;

    @Id
    @Column(name = "sys_product_id")
//    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private int productId;

    @Column(name = "last_update", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdate;

}