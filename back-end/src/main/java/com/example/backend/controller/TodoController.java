package com.example.backend.controller;

import com.example.backend.controller.DTO.TodoDTO;
import com.example.backend.entity.Todos;
import com.example.backend.service.TodosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@Api(tags = "todolist-controller")
public class TodoController {

    @Autowired
    private TodosService todosService;

    @ApiOperation("add todo Items")
    @PostMapping("/add")
    public Todos addTodo(@RequestBody TodoDTO todoDTO){
        todoDTO.setTodoId(0);
        return todosService.addTodo(todoDTO);
    }

    @ApiOperation("update current todo Items")
    @PostMapping("/update")
    public void updateTodo(@RequestBody TodoDTO todoDTO){
        todosService.addTodo(todoDTO);
    }

    @ApiOperation("Inactive todo items")
    @GetMapping("/inactive")
    public boolean inactiveTodo(@RequestParam int todoId){
        return todosService.inactiveTodo(todoId);
    }

    @ApiOperation("find all todo items")
    @GetMapping("/findAll")
    public List<Todos> findAll(@RequestParam int page, int size, String sortBy){
        return todosService.findAllTodo(page, size, sortBy);
    }

    @ApiOperation("find all todo items by client Id")
    @GetMapping("/findById")
    public List<Todos> findByClientId(@RequestParam int page, int size, int clientId){
        return todosService.findAllTodoByClientId(page, size, clientId);
    }
}
