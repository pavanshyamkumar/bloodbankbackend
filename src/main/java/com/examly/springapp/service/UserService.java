package com.examly.springapp.service;

import java.util.Set;

import com.examly.springapp.entity.User;
import com.examly.springapp.entity.UserRole;



public interface UserService {
	
	//creating user
	
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//get user by name
	
	public User getUser(String Username);
	
	
	//get user by id
	
	public User getUserbyId(Long id);
	
	//delete user by id
	
	public void deleteuser(Long userId);
	
	//update caterory
	
	public User updateUser(User user) throws Exception;
	
	//get all users
	
	public Set<User> getUsers();
}
