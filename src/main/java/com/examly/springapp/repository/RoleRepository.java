package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.entity.Role;



public interface RoleRepository extends JpaRepository<Role,Long> {
	
	

}
