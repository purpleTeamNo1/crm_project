package com.example.backend.controller;

import com.example.backend.controller.DTO.ClientDTO;
import com.example.backend.controller.DTO.TodoDTO;
import com.example.backend.entity.Client;
import com.example.backend.entity.Todos;
import com.example.backend.service.ClientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @ApiOperation("add client")
    @PostMapping("/add")
    public void addClient(@RequestBody ClientDTO clientDTO){
        clientDTO.setClientId(0);
        clientService.addClient(clientDTO);
    }

    @ApiOperation("update current todo Items")
    @PostMapping("/update")
    public void updateTodo(@RequestBody ClientDTO clientDTO){
        clientService.addClient(clientDTO);
    }

    @ApiOperation("Inactive todo items")
    @GetMapping("/inactive")
    public boolean inactiveTodo(@RequestParam int clientId){
       return clientService.inactiveClient(clientId);
    }

    @ApiOperation("find all todo items")
    @GetMapping("/findAll")
    public List<Client> findAll(@RequestParam int page, int size, String sortBy){
        return clientService.findAllClient(page, size, sortBy);
    }

//    @ApiOperation("find all todo items by client Id")
//    @GetMapping("/findById")
//    public List<Todos> findByClientId(@RequestParam int page, int size, int clientId){
//        return todosService.findAllTodoByClientId(page, size, clientId);
//    }
}
