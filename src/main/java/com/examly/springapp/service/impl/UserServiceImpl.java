package com.examly.springapp.service.impl;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.User;
import com.examly.springapp.entity.UserRole;
import com.examly.springapp.repository.RoleRepository;
import com.examly.springapp.repository.UserRepository;
import com.examly.springapp.service.UserService;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		
		User local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null)
		{
			System.out.println("user is alredy there");
			throw new Exception("User already presant");
		}
		else
		{
			for(UserRole ur:userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local=this.userRepository.save(user);
			
			
		}
		return local;
	}
	
	
	//get user by user name

	@Override
	public User getUser(String Username) {
		
		return this.userRepository.findByUsername(Username);
	}

	
	
	//delete user by id
	@Override
	public void deleteuser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}


	

	@Override
	public Set<User> getUsers() {
		
		return new HashSet<>(this.userRepository.findAll());
	}


	@Override
	public User updateUser(User user) throws Exception {
		
		
		User exeistinguser=this.userRepository.findById(user.getId()).orElse(null);
		exeistinguser.setUsername(user.getUsername());
		exeistinguser.setFirstName(user.getFirstName());
		exeistinguser.setLastName(user.getLastName());
		exeistinguser.setEmail(user.getEmail());
		exeistinguser.setPhone(user.getPhone());
		return this.userRepository.save(exeistinguser);
	}


	@Override
	public User getUserbyId(Long id) {
		User user=this.userRepository.findById(id).orElse(null);
		user.getUsername();
		user.getFirstName();
		user.getLastName();
		user.getEmail();
		user.getPhone();
		return user;
	}
	
	
	
	

}

