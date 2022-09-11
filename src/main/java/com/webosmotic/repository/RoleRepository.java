package com.webosmotic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webosmotic.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findRoleByName(String name);
}