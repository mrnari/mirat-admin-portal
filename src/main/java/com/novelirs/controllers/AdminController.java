package com.novelirs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.novelirs.model.User;
import com.novelirs.service.UsersService;

@Controller
public class AdminController {

	@Autowired
	UsersService userService;


	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index() {
		return "login";
	}
	
	@RequestMapping("/welcome")
	public String firstPage() {
		return "welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/admin/addNewUser", method = RequestMethod.POST)
	public String processRequest(Model model,@ModelAttribute("user") User user) {
		
		userService.insertUser(user);
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "usersList";
	}
	
	
	@RequestMapping("/admin/deleteUser")
	public String deleteUser(Model model,@RequestParam(value = "id") int id) {
		userService.deleteUser(id);
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "usersList";
	}

}
