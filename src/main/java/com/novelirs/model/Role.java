package com.novelirs.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 
 *
 */
public class Role implements Serializable{
	
	private Integer id;
	
	@NotEmpty
	private String name;
		
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

	
}
