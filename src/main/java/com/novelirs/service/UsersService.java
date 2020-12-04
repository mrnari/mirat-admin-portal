package com.novelirs.service;

import java.util.List;

import com.novelirs.model.User;

public interface UsersService {
	
	int insertUser(User user);
	List<User> getUsers();
	User getUserById(int userId);
	User getUserByName(String name);
	void deleteUser(int id);

}