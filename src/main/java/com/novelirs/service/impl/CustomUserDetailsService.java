package com.novelirs.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.novelirs.dao.UserDao;
import com.novelirs.model.Role;
import com.novelirs.model.User;
/**
 * @author Narendra Kusam
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserDao userDao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could Not Find User");
		}

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), true, true, true, 
                true, getAuthorities(user.getId()));
	}
	

	public Collection<? extends GrantedAuthority> getAuthorities(Integer id) {
		List<Role> roles = userDao.getAllRolesByUserId(id);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}


}
