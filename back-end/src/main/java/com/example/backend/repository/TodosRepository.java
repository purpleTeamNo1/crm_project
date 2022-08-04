package com.example.backend.repository;

import com.example.backend.entity.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosRepository extends JpaRepository<Todos, Integer> {


}
