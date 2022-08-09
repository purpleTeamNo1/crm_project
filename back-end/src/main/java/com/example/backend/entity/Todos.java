package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "todolist")
@ToString(exclude = {"client"})
@ApiModel
public class Todos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todoid")
    @ApiModelProperty(allowEmptyValue = true)
    private int todoId;

    @Column(name = "title", length=50, nullable = false)
    @ApiModelProperty(required = true)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "priority", nullable = false)
    @ApiModelProperty(required = true)
    private int priority;

    @Column(name="last_update", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdate;

    @Column(name = "duedate")
    private Date dueDate;

    @Column(name="completion", nullable = false)
    private boolean isComplete;

    @Column(name="location", length=100)
    private String location;

    @Column(name = "note")
    private String note;
    @JsonManagedReference
    @ManyToOne(targetEntity = Client.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ApiModelProperty
    private Client client;
}
