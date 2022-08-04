package com.example.backend.service.impl;

import com.example.backend.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodosServiceImpl {

    @Autowired
    private TodosRepository todosRepository;


}
