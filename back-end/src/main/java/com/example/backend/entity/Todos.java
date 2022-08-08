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
@Table(name = "tb_todos")
@ToString(exclude = {"user"})
@ApiModel
public class Todos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
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

    @Column(name="entry_time", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @ApiModelProperty(required = true)
    private Timestamp entryTime;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name="iscomplete", nullable = false)
    private boolean isComplete;

    @Column(name="location", length=100)
    private String location;

    @JsonManagedReference
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ApiModelProperty
    private User user;
}
