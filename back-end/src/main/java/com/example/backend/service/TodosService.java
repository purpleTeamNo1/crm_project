package com.example.backend.service;

import com.example.backend.controller.DTO.TodoDTO;
import com.example.backend.entity.Todos;

import java.util.List;

public interface TodosService {

    void addTodo(TodoDTO todoDTO);

//    List<Todos> findAllTodo(int page, int size);

    List<Todos> findAllTodo(int page, int size, String sortBy);
}
