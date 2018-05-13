package com.jesus.rest.webservice.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description="All details about user")	// swager api
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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
	
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;

	public User(Integer id,  String name,Date bithDate) {
		this.id = id;
		this.name = name;
		this.bithDate = bithDate;
	}
	
	

}
