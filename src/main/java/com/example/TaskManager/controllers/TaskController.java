package com.example.TaskManager.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.services.TaskService;
import com.example.TaskManager.services.UserService;

@Controller
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	UserService userService;
	
	
	@GetMapping(value="/task")
    public String showTaskPage(@RequestParam("userId") int userId, ModelMap model) {   
		model.addAttribute("userId", userId);
		return "taskform";
	}
	
	@GetMapping(value="/tasks")
    public String showAllTasksPage(ModelMap model, int userId) {   
		Iterable<Task> tasks = taskService.GetTasksByUser(userService.getUserById(userId));
		model.addAttribute("tasks", tasks);
		model.addAttribute("userId", userId);
		return "tasks";
	}
	
	@RequestMapping(value = "/task")
	public String addTask(@RequestParam("name") String name, @RequestParam("desc") String desc
			, @RequestParam("sev") String sev,  @RequestParam("sdate") @DateTimeFormat(pattern="yyyy-MM-dd") Date sdate
			, @RequestParam("edate") @DateTimeFormat(pattern="yyyy-MM-dd") Date edate, @RequestParam("userId") int userId
			, ModelMap model) {
		System.out.println(name);
		System.out.println(sdate);
		System.out.println(edate);
		Task task = new Task(name, sdate, edate, sev, desc, "email", userService.getUserById(userId));
		taskService.addTask(task);
		Iterable<Task> tasks = taskService.GetTasksByUser(userService.getUserById(userId));
		model.addAttribute("tasks", tasks);
		model.addAttribute("userId", userId);
		return "tasks";
	}
	
	@GetMapping(value = "/updateTask")
	public String InitateUpdateTask(@RequestParam("taskId") int taskId, @RequestParam("userId") int userId, ModelMap model) {
		Task task = taskService.getTaskById(taskId);
		model.addAttribute("task", task);
		model.addAttribute("userId", userId);
		return "updateTask";
	}
	
	@RequestMapping(value = "/updateTask")
	public String updateTask (@RequestParam("taskId") int taskId, @RequestParam("userId") int userId, @RequestParam("name") String name, @RequestParam("desc") String desc
			, @RequestParam("sev") String sev,  @RequestParam("sdate") @DateTimeFormat(pattern="yyyy-MM-dd") Date sdate
			, @RequestParam("edate") @DateTimeFormat(pattern="yyyy-MM-dd") Date edate
			, ModelMap model){
		System.out.println(taskId);
		System.out.println(userId);
		System.out.println("next");
		System.out.println(name);
		System.out.println(sdate);
		System.out.println(edate);
		Task task = new Task( taskId, name, sdate, edate, sev, desc, "email", userService.getUserById(userId));
		taskService.addTask(task);
		Iterable<Task> tasks = taskService.GetTasksByUser(userService.getUserById(userId));
		model.addAttribute("tasks", tasks);
		model.addAttribute("userId", userId);
		return "tasks";
	}
	
	@GetMapping(value = "/deleteTask")
	public String DeleteTask(@RequestParam("taskId") int taskId, @RequestParam("userId") int userId, ModelMap model) {
		taskService.deleteTask(taskId);
		Iterable<Task> tasks = taskService.GetTasksByUser(userService.getUserById(userId));
		model.addAttribute("tasks", tasks);
		model.addAttribute("userId", userId);
		return "tasks";
	}
	

}
