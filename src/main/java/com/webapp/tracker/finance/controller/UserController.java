package com.webapp.tracker.finance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.tracker.finance.exception.UserNotFoundException;
import com.webapp.tracker.finance.model.User;
import com.webapp.tracker.finance.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to Finance Tracking website!!";
	}
	
	@PostMapping("/user")
	public User createUser(@Validated @RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUsers(){
		return userService.getAllUser();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int uid) throws UserNotFoundException{
		Optional<User> user=userService.getUserById(uid);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			throw new UserNotFoundException("User with give id does not exist!!");
		}
	}
	
	@GetMapping("/user/username/{uname}")
	public User getUserByUsername(@PathVariable("uname") String uname) throws UserNotFoundException{
		Optional<User> user=userService.getUserByUserName(uname);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			throw new UserNotFoundException("User with give this username does not exist!!");
		}
	}
	
}
