package com.webapp.tracker.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.tracker.finance.model.User;
import com.webapp.tracker.finance.repos.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepo;
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	//Restrict this operation later for only Admin.
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	//Restrict this operation later for only Admin.
	public Optional<User> getUserById(int uid){
		return userRepo.findById(uid);
	}
	
	//Restrict this operation later for only Admin.
	public Optional<User> getUserByUserName(String uname){
		return userRepo.findByUsername(uname);   // defined in repository
	}
	
	//Restrict this operation later for only Admin.
	public void deleteUserById(int uid) {
		userRepo.deleteById(uid);
	}
	
}
