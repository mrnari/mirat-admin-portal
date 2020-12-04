package com.novelirs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.novelirs.dao.UserDao;
import com.novelirs.model.Role;
import com.novelirs.model.User;

/**
 * @author Narendra Kusam
 *
 */

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(User user) {
		return jdbcTemplate.update(
				"insert into users (name, email,password) values(?,?,?)",
				user.getName(), user.getEmail(),user.getPassword());
	}

	@Override
	public int updateUser(User user) {
		return jdbcTemplate.update(
				"update users set name = ?,email = ?,password = ? where id = ?",
				user.getName(), user.getEmail(),user.getPassword());
	}

	@Override
	public List<User> list() {
		List<User> data = jdbcTemplate.query("select * from users", new RowMapper<User>() {
			@Override
			public User mapRow(java.sql.ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
		return data;
	}

	@Override
	public User findUserById(int id) {

		return  jdbcTemplate.query("select * from users where id = ?",new Object[]{id},new ResultSetExtractor<User>() {
			@Override
			public User extractData(java.sql.ResultSet rs) throws SQLException {
				User user = new User();
				if(rs.next()){
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
				}
				return user;
			}
		});
	}		

	@Override
	public User findByEmail(String email) {

		return  jdbcTemplate.query("select * from users where email = ?",new Object[]{email},new ResultSetExtractor<User>() {
			@Override
			public User extractData(java.sql.ResultSet rs) throws SQLException {
				User user = new User();
				if(rs.next()){
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
				}
				return user;
			}
		});
	}		

	@Override
	public int deleteUser(int id) {
		return jdbcTemplate.update(
				"delete users where id = ?",
				id);
	}

	@Override
	public User findUserByName(String name) {
		return  jdbcTemplate.query("select * from users where name = ?",new Object[]{name},new ResultSetExtractor<User>() {
			@Override
			public User extractData(java.sql.ResultSet rs) throws SQLException {
				User user = new User();
				if(rs.next()){
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
				}
				return user;
			}
		});
	}

	@Override
	public List<Role> getAllRolesByUserId(Integer id) {
		
		List<Role> data = jdbcTemplate.query("select r.id,r.name from roles r inner join user_role ur on ur.role_id = r.id where ur.user_id = ?",new Object[] {id}, new RowMapper<Role>() {
			@Override
			public Role mapRow(java.sql.ResultSet rs, int arg1) throws SQLException {
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				return role;
			}
		});
		return data;
	}
}
