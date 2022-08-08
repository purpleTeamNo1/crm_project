package com.example.backend;

import com.example.backend.entity.Todos;
import com.example.backend.entity.User;
import com.example.backend.repository.TodosRepository;
import com.example.backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class TodosTest {

    @Autowired
    private TodosRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void addTodos(){
        Todos todos = new Todos();
        todos.setTitle("test");
        todos.setDescription("This is just for test");
        todos.setPriority(1);
        todos.setComplete(false);
        User user = userRepository.findById(5).get();
        user.getTodosList().add(todos);
        todos.setUser(user);

        repository.save(todos);

//        System.out.println(repository.save(todos));

    }
}
