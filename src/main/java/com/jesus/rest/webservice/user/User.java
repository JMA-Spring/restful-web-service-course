package com.jesus.rest.webservice.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


public class User {
	private Integer id;
	
	@Size(min=2, message="name should have at least two characters, :)")
	private String name;
	
	@Past
	private Date bithDate;
	
	protected User() {
		
	}
	
	public User(Integer id, String name, Date bithDate) {
		this.id = id;
		this.name = name;
		this.bithDate = bithDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBithDate() {
		return bithDate;
	}
	public void setBithDate(Date bithDate) {
		this.bithDate = bithDate;
	}

}
