package com.example.backend;

import com.example.backend.entity.Client;
import com.example.backend.entity.Todos;
import com.example.backend.entity.User;
import com.example.backend.repository.ClientRepository;
import com.example.backend.repository.TodosRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.TodosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TodosTest {

    @Autowired
    private TodosRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TodosService todosService;

    @Test
    @Transactional
    @Rollback(false)
    public void addTodos(){
        Todos todos = new Todos();
        todos.setTitle("test");
        todos.setDescription("This is just for test");
        todos.setPriority(1);
        todos.setComplete(false);
        Client client = clientRepository.findById(1).get();
//        System.out.println(client);
        client.getTodosList().add(todos);
        todos.setClient(client);

        repository.save(todos);

//        System.out.println(repository.save(todos));

    }

    @Test
    @Transactional
    public void findAllByOrderTest(){
        List<Todos> allTodos = todosService.findAllTodo(0,5, "dueDate");
//        System.out.println(allTodos.stream().count());
        System.out.println(allTodos);
    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void updateTodoTest(){
        Todos todos = new Todos();
        todos.setTodoId(6);
        todos.setTitle("update test");
        todos.setDescription("This is just for update test");
        todos.setPriority(1);
        todos.setComplete(false);
        Client client = clientRepository.findById(1).get();
//        System.out.println(client);
        client.getTodosList().add(todos);
        todos.setClient(client);

        repository.save(todos);
    }
}
