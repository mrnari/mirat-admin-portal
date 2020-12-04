package com.novelirs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novelirs.dao.UserDao;
import com.novelirs.model.User;
import com.novelirs.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	UserDao userDao;


	@Override
	public int insertUser(User user) {
		if(user.getId()!=null && user.getId()>0) {
			return userDao.updateUser(user);
		}else {
			return userDao.save(user);	
		}
		
	}

	@Override
	public List<User> getUsers() {
		return userDao.list();
	}

	@Override
	public User getUserById(int id) {
		return userDao.findUserById(id);
	}

	@Override
	public User getUserByName(String name) {
		return userDao.findUserByName(name);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}


}
