package com.example.backend.service.impl;

import com.example.backend.common.Result;
import com.example.backend.controller.DTO.TodoDTO;
import com.example.backend.entity.Client;
import com.example.backend.entity.Todos;
import com.example.backend.entity.User;
import com.example.backend.repository.ClientRepository;
import com.example.backend.repository.TodosRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.TodosService;
import com.example.backend.utils.DateAndTimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodosServiceImpl implements TodosService {

    @Autowired
    private TodosRepository todosRepository;

    @Autowired
    private ClientRepository clientRepository;

    //1. Create TodoList
    public Todos addTodo(TodoDTO todoDTO) {
        Todos todos = new Todos();
        BeanUtils.copyProperties(todoDTO, todos);
        todos.setLastUpdate(DateAndTimeUtils.getCurrentTime());
        Client client = clientRepository.findById(todoDTO.getClientId()).get();
        client.getTodosList().add(todos);
        todos.setClient(client);
        return todosRepository.save(todos);
    }

    //2. query TodoList
    //2.1 query all TodoList order by provide condition
    public List<Todos> findAllTodo(int page, int size, String orderBy){
        List allTodos = todosRepository.findAll(PageRequest.of(page,size, Sort.by(orderBy).ascending())).get().toList();
//        List allTodos = todosRepository.findAllByOrderByIdAsc(PageRequest.of(page,size));
        return allTodos;
    }

    //2.1 query all todos by given client Id
    public List<Todos> findAllTodoByClientId(int page, int size, int clientId){
        Client client = clientRepository.findById(clientId).get();
        List<Todos> todos = todosRepository.findAllByClient(client);
        return todos;
    }



    //3. update TodoList, using addTodo() method but using todoId as condition for updating.

    // 4. inactive TodoList
    public boolean inactiveTodo(int todoId){
        Todos todo = todosRepository.findById(todoId).get();
        if(todo!= null){
            todo.setComplete(true);
            return true;
        }
        return false;
    }

}
