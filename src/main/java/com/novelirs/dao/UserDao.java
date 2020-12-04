package com.novelirs.dao;

import java.util.List;

import com.novelirs.model.Role;
import com.novelirs.model.User;



public interface UserDao {

	User findByEmail(String email);

	int save(User user);

	List<User> list();

	User findUserById(int id);

	int updateUser(User user);

	int deleteUser(int id);

	User findUserByName(String name);

	List<Role> getAllRolesByUserId(Integer id);

}
