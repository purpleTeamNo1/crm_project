package com.example.backend.service;

import com.example.backend.controller.DTO.ClientDTO;
import com.example.backend.entity.Client;

import java.util.List;

public interface ClientService {
    void addClient(ClientDTO clientDTO);

    List<Client> findAllClient(int page, int size, String orderBy);

    List<Client> findAllClientByDync(String firstName, String lastName, String homePhone,String cellPhone, String email);

    boolean inactiveClient(int clientId);
}
