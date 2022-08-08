package com.example.backend.service.impl;

import com.example.backend.controller.DTO.ClientDTO;
import com.example.backend.entity.Client;
import com.example.backend.repository.ClientRepository;
import com.example.backend.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    //1. Create client
    public void addClient(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        clientRepository.save(client);
    }

    //2.1 query all clients order by define property
    public List<Client> findAllClient(int page, int size, String orderBy){
        List clients = clientRepository.findAll(PageRequest.of(page,size, Sort.by(orderBy).ascending())).get().toList();
//        List allTodos = todosRepository.findAllByOrderByIdAsc(PageRequest.of(page,size));
        return clients;
    }

    // 2.2 query client by define properties dynamically
//    public List<Client> findAllTodoByLastName(int page, int size, int clientId){
//        List<Integer> ids = new ArrayList<>();
//        ids.add(clientId);
//        List<Todos> todos = todosRepository.findAllById(ids);
//        return todos;
//    }

    //3. update TodoList, using addTodo() method but using clientId as condition for updating.

    // 4. inactive TodoList
    public boolean inactiveClient(int clientId){
        Client client= clientRepository.findById(clientId).get();
        if(client!= null){
            client.setStatus(0);
            return true;
        }
        return false;
    }
}
