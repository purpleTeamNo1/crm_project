package com.example.backend;

import com.example.backend.entity.Client;
import com.example.backend.repository.ClientRepository;
import com.example.backend.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ClientTest {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @Transactional
    public void queryByExampleTest(){
        List<Client> clientList = clientService.findAllClientByDync(null,"tyler",null,null,null);

        System.out.println(clientList);

    }
}
