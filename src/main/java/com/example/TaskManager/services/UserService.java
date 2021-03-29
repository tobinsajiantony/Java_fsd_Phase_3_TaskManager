package com.example.TaskManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.models.Message;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	//Authentication Related
	  public Iterable<User> GetAllUsers()
	    {
	        return userRepository.findAll();
	    }


	    public User GetUserByName(String name) {
	        User foundUser = userRepository.findByName(name);
	        return foundUser;
	    }
	    
	    public User GetUserById(int id) {
	    	User foundUser = userRepository.findById(id).orElse(null);
	    	return foundUser;
	    }
	    
	    public Message authenticateUser(String name, String password) {
	    	if(name != "" && password != "") {
	    	User user = userRepository.findByNameAndPassword(name, password);
	        if(user != null)
	        	return new Message(true, "Logged-In Successfully", user.getId());
	        else
	        	return new Message(false, "Name or Password Not Valid!");
	    	}
	    	else if(name == "") {
	    		return new Message(false, "Enter Name!");
	    	}
	    	else {
	    		return new Message(false, "Enter Password!");
	    	}
	    }
	    
	    public Message createUser(String name, String password, String passwordre, String email) {
	    	System.out.println(name);
	    	System.out.println(password);
	    	System.out.println(passwordre);
	    	System.out.println(email);
	    	if(name!="" && password!="" && passwordre!="" && email!="") 
	    	{
	    		if(password.equals(passwordre)) {
	    			User user = new User(name, email, password);
	    			user = userRepository.save(user);
	    			return new Message(true, "User added Successfully", user.getId());
	    		}
	    		else {
	    			return new Message(false, "The Entered Passwords Do Not Match!");
	    		}
	    	}
	    	else if (name == "")
	    	{
	    		return new Message(false, "Please Enter The Name!");
	    	}
	    	else if (email == "")
	    	{
	    		return new Message(false, "Please Enter The Email!");
	    	}
	    	else if (password == "")
	    	{
	    		return new Message(false, "Please Enter The Password!");
	    	}
	    	else
	    	{
	    		return new Message(false, "Please Re-Enter The Password!");
	    	}
	    	
	    }
	//
}
