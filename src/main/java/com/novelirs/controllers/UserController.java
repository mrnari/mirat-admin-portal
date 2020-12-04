package com.novelirs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.novelirs.model.User;
import com.novelirs.service.UsersService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UsersService userService;
	
	@RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
	public String show(Model model) {
		model.addAttribute("user", new User());
		return "user";
	}
	
	@RequestMapping("/getUsers")
	public String getUsers(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "usersList";
	}

	
}
