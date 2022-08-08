package com.example.backend.controller;

import com.example.backend.controller.DTO.TodoDTO;
import com.example.backend.service.TodosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
@Api(tags = "Controller for todolist")
public class TodoController {

    @Autowired
    private TodosService todosService;

//    @ApiOperation("add todo Items")
//    @PostMapping("/add")
//    public void addTodo(@RequestBody TodoDTO todoDTO){
//        todosService.addTodo(todoDTO);
//    }
}
