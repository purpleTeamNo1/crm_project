package com.example.backend.service;

import com.example.backend.controller.DTO.ClientDTO;
import com.example.backend.entity.Client;

import java.util.List;

public interface ClientService {
    void addClient(ClientDTO clientDTO);

    List<Client> findAllClient(int page, int size, String orderBy);

    boolean inactiveClient(int clientId);
}
