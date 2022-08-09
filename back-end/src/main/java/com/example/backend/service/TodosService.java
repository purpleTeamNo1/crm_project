package com.example.backend.service;

import com.example.backend.common.Result;
import com.example.backend.controller.DTO.TodoDTO;
import com.example.backend.entity.Todos;

import java.util.List;

public interface TodosService {

    Todos addTodo(TodoDTO todoDTO);

//    List<Todos> findAllTodo(int page, int size);

    List<Todos> findAllTodo(int page, int size, String orderBy);

    List<Todos> findAllTodoByClientId(int page, int size, int clientId);

    boolean inactiveTodo(int todoId);
}
