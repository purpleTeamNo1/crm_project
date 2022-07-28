package com.example.backend.repository;


import com.example.backend.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    User findUserByUsername(String username);
}
