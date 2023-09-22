package com.abhishek.blogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.blogapi.model.role.Role;
import com.abhishek.blogapi.model.role.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(RoleName name);
}
