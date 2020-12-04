package com.novelirs.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Configuration;

/**
 * @author Narendra Kusam
 *
 */

public class User implements Serializable{
	
	private Integer id;

	@NotEmpty()
	private String name;

	@NotEmpty
	@Email(message="{errors.invalid_email}")
	private String email;

	@NotEmpty
	@Size(min=4)
	private String password;

	private List<Role> roles;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public List<Role> getRoles()
	{
		return roles;
	}
	public void setRoles(List<Role> roles)
	{
		this.roles = roles;
	}
	
}
