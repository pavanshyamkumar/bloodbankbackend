package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.entity.User;


public interface UserRepository extends JpaRepository<User,Long> {

	

	public User findByUsername(String username);
	
	
	
	

}