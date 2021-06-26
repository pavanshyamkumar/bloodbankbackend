package com.examly.springapp.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.examly.springapp.entity.Product;
import com.examly.springapp.entity.Role;
import com.examly.springapp.entity.User;
import com.examly.springapp.entity.UserRole;
import com.examly.springapp.service.ProductService;
import com.examly.springapp.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	public ProductService service;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception
	{
		
		//bcrypt password
		
		user.setPassword(this.bcryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles=new HashSet<>();
		Role role =new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole =new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		
		return this.userService.createUser(user, roles);
	}
	
	@PostMapping("/usersignup")
	public User createUsernormal(@RequestBody User user) throws Exception
	{
		
		//bcrypt password
		
		user.setPassword(this.bcryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles=new HashSet<>();
		Role role =new Role();
		role.setRoleId(47L);
		role.setRoleName("USER");
		
		UserRole userRole =new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		
		return this.userService.createUser(user, roles);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username)
	{
		return this.userService.getUser(username);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId)
	{
		this.userService.deleteuser(userId);
	}
	
	@PutMapping("/user/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception
	{
		
		
		
		
		return ResponseEntity.ok(this.userService.updateUser(user));
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getallUsers(){
		return ResponseEntity.ok(this.userService.getUsers());
	}
	
	@GetMapping("/getuser/{userid}")
	public Map<String, Object> getuserbyId(@PathVariable("userid") Long id)
	{
		User user=this.userService.getUserbyId(id);
		
		 Map<String, Object> gameMap = new HashMap<>();
		 
		 gameMap.put("id", user.getId());
		 gameMap.put("username", user.getUsername());
		 gameMap.put("firstName", user.getFirstName());
		 gameMap.put("lastName", user.getLastName());
		 gameMap.put("email", user.getEmail());
		 gameMap.put("phone", user.getPhone());
		return gameMap;
	}
	
	
	
	@PostMapping("/addseries")
	public Product addProduct(@RequestBody Product product)
	{
		return service.saveProduct(product);
		
	}
	
	@PostMapping("/addproducts")
	public List<Product> addProduct(@RequestBody List<Product> products)
	{
		return service.saveProducts(products);
		
	}
	
	@GetMapping("/series")
	public List<Product> findAllProducts()
	{
		return service.getProducts();
	}
	
	
	@GetMapping("/series/id/{id}")
	public Product findProductById(@PathVariable int id)
	{
		return service.getProductById(id);
	}
	
	@GetMapping("/series/name/{name}")
	public Product findProductByName(@PathVariable String name)
	{
		return service.getProductByName(name);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product)
	{
		return service.updateProduct(product);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return service.deleteProduct(id);
	}
	

}
