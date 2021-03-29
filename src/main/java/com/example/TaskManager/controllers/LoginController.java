package com.example.TaskManager.controllers;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.TaskManager.models.Message;
import com.example.TaskManager.services.UserService;


@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired 
	TaskController taskController;

  
    @GetMapping("/")
    public String showLogin(ModelMap map) {
        return "login";
    }
    
    @GetMapping("/createAccount")
    public String showCreateAccount(ModelMap map) {
        return "createAccount";
    }

    @PostMapping("/login")
    public String submitLogin(@RequestParam String username, @RequestParam String password, ModelMap model, HttpServletResponse response){
       
       Message message = userService.authenticateUser(username, password);
       model.addAttribute("message", message.getData());  
       if(message.isValid() == true)
       {
    	   Cookie newCookie = new Cookie("testCookie", "testCookieValue");
           newCookie.setMaxAge(24 * 60 * 60);
           response.addCookie(newCookie);
    	  return taskController.showAllTasksPage(model, message.getId());
       }
       else
       {
    	   return "error";
       }
    }
    
    @PostMapping("/createAccount")
    public String submitCreateAccount(@RequestParam String username, @RequestParam String password
    		, @RequestParam String passwordre, @RequestParam String email, ModelMap model){

    	Message message = userService.createUser(username, password, passwordre, email);
    	model.addAttribute("message", message.getData());    
       if(message.isValid())
       {
    	   return taskController.showAllTasksPage(model, message.getId());
       }
       else
       {
    	   return "error";
       }
    }
}
