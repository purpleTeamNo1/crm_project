package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@ToString(exclude = {"product"})
@Table(name = "insurance")

public class Insurance {
    @Id
    @Column(name = "insuranceid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int insuranceId;

//    @Column(name = "productcode", length = 50)
//    private String productCode;

    @Column(name = "policynumber", length = 50)
    private String policyNumber;

    @Column(name = "applicationnumber", length = 50)
    private String applicationNumber;

    @Column(name = "applicationdate")
    private Date applicationDate;

    @Column(name="coi", columnDefinition = "Decimal(13,2)")
    private double coi;

    @Column(name = "enforcementdate")
    private Date enforcementDate;

    @Column(name = "maturitydate")
    private Date maturityDate;

    @Column(name = "coverageamount", columnDefinition = "Decimal(13,2)")
    private double coverageAmount;

    @Column(name = "additionaldeposit", columnDefinition = "Decimal(13,2)")
    private double additionalDeposit;

    @Column(name = "paymenttime")
    private int paymentTime;

    @Column(name = "riders", length = 50)
    private String riders;

    @Column(name = "province", length = 50)
    private String province;

    @Column(name = "note")
    private String note;

    @Column(name = "last_update", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdate;

    @JsonBackReference
    @OneToOne(mappedBy = "insurance", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Product product;
}
