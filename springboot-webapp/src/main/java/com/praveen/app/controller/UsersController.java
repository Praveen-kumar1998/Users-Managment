package com.praveen.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.praveen.app.entity.Users;
import com.praveen.app.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService us;

	// To the First Page
	@GetMapping("/")
	public String firstPage() {
		return "index";
	}

	// To show all users
	@GetMapping("/showUser")
	public String showUsers(Model model) {
		model.addAttribute("listUsers", us.getAll());
		return "allUsers";
	}

	// To save User and sending user model to bind the data
	@GetMapping("/newUser")
	public String addUser(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return "new_user";
	}
	//Creating a new user and save it to the data base
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") Users user) {
		// Save user to db
		us.saveUser(user);
		return "redirect:/showUser";
	}
	//To find the user by id
	@GetMapping("/updateUser/{id}")	
	public String updateUser(@PathVariable("id") int id,Model mod) {
		mod.addAttribute("user",us.getById(id));
		return "update_form";
	}
	//To delete the user by id
	@GetMapping("/deleteUser/{id}")
	public String delUser(@PathVariable("id") int id) {
		us.delUser(id);
		return "redirect:/showUser";
	}
	
	//To about page
	@GetMapping("/about")
	public String aboutDev() {
		return "abt_dev";
	}
}






















