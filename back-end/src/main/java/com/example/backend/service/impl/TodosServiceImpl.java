package com.example.backend.service.impl;

import com.example.backend.controller.DTO.TodoDTO;
import com.example.backend.entity.Todos;
import com.example.backend.entity.User;
import com.example.backend.repository.TodosRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.TodosService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodosServiceImpl implements TodosService {

    @Autowired
    private TodosRepository todosRepository;

    @Autowired
    private UserRepository userRepository;

    public void addTodo(TodoDTO todoDTO){
        Todos todos = new Todos();
        BeanUtils.copyProperties(todoDTO, todos);
        User user = userRepository.findById(todoDTO.getUserId()).get();
        user.getTodosList().add(todos);
        todos.setUser(user);
        todosRepository.save(todos);
    }
}
