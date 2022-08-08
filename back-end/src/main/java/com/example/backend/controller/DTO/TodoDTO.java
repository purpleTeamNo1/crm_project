package com.example.backend.controller.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class TodoDTO {
    @ApiModelProperty(required = true)
    private int todoId;

    @ApiModelProperty(required = true)
    private String title;

    private String description;

    private Date dueDate;

    @ApiModelProperty(required = true)
    private int priority = 1;

    @ApiModelProperty(required = true)
    private Timestamp lastUpdate;

    @ApiModelProperty(required = true)
    private boolean isComplete;

    private String location;

    private int clientId;

}
