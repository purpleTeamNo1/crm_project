package com.example.backend.repository;

import com.example.backend.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {

    Role findRoleByRoleId(int roleId);
}
