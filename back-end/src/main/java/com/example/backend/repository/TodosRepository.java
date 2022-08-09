package com.example.backend.repository;

import com.example.backend.entity.Client;
import com.example.backend.entity.Todos;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosRepository extends JpaRepository<Todos, Integer> {

    List<Todos> findAllByClient(Client client);
}
