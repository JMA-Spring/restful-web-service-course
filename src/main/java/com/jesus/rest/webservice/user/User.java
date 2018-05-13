package com.jesus.rest.webservice.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about user")	// swager api
@Entity
@SequenceGenerator(name="user", initialValue=10, allocationSize=100)
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user")
	private Integer id;
	
	@Size(min=2, message="name should have at least two characters, :)")
	@ApiModelProperty(notes="name should have two characters")  // swager api 
	private String name;
	
	@Past
	@ApiModelProperty(notes="fecha valida :)")	// swager api 
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
