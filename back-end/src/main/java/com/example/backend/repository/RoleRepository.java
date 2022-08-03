package com.example.backend.repository;

import com.example.backend.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {

    Role findRoleByRoleId(int roleId);
}
