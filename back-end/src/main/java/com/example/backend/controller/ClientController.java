package com.example.backend.controller;

import com.example.backend.controller.DTO.ClientDTO;
import com.example.backend.controller.DTO.QueryClientDTO;
import com.example.backend.entity.Client;
import com.example.backend.entity.Todos;
import com.example.backend.service.ClientService;
import com.example.backend.service.TodosService;
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


    @ApiOperation("find all client by different conditions dynamically")
    @PostMapping("/findByDync")
    public List<Client> findByDync(@RequestBody QueryClientDTO queryClientDTO){
        String firstName = queryClientDTO.getFirstName();
        String lastName = queryClientDTO.getLastName();
        String homePhone = queryClientDTO.getHomePhone();
        String cellPhone = queryClientDTO.getCellPhone();
        String email = queryClientDTO.getEmail();

        List<Client> clients = clientService.findAllClientByDync(firstName, lastName, homePhone, cellPhone, email);
        return clients;
    }

}
