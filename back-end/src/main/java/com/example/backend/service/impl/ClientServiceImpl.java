package com.example.backend.service.impl;

import com.example.backend.controller.DTO.ClientDTO;
import com.example.backend.entity.Client;
import com.example.backend.repository.ClientRepository;
import com.example.backend.service.ClientService;
import com.example.backend.utils.DateAndTimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
        client.setLastUpdate(DateAndTimeUtils.getCurrentTime());
        clientRepository.save(client);
    }

    // 2. query client
    //2.1 query all clients order by define property
    public List<Client> findAllClient(int page, int size, String orderBy){
        List clients = clientRepository.findAll(PageRequest.of(page,size, Sort.by(orderBy).ascending())).get().toList();
//        List allTodos = todosRepository.findAllByOrderByIdAsc(PageRequest.of(page,size));
        return clients;
    }

     //2.2 query client by define properties dynamically
    public List<Client> findAllClientByDync(String firstName, String lastName, String homePhone,String cellPhone, String email){
        Client client = new Client();
        client.setFirstname(firstName);
        client.setLastName(lastName);
        client.setHomePhone(homePhone);
        client.setCellPhone(cellPhone);
        client.setEmail(email);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("clientId","giftGiven","status","age")
                .withIgnoreCase("firstName", "lastName")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Client> clientExample = Example.of(client,matcher);

        List<Client> clientList = clientRepository.findAll(clientExample);

        return clientList;
    }

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
