package com.jesus.rest.webservice.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.URIEditor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jesus.rest.webservice.exception.ExceptionResponse;

@RestController
public class UserResourceJPA {

	@Autowired
	private UserRepositoryJPA service;

	@RequestMapping(path = "/jpa/users", method = RequestMethod.GET)
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = service.findById(id);
		
		if (!user.isPresent())
			throw new UserNotFoundException("id-"+id);		// exception if there is no user
		
		//HATEOAS
		Resource<User> resource = new Resource<User>(user.get());		//el recuros que deseamos regresar, el tipo de recurso es User
		// Clase para hacer links	linkTo(methodOn(class).method))
		ControllerLinkBuilder linkto = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkto.withRel("all-users"));	// se agrega el link al resource, y se le da un nombre
		
		return resource;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity createUser(@Valid @RequestBody User user) {	// Response entity extends httpentity, te permite agregar un status code a la respuesta
		User savedUser = service.save(user);				//user created to be returned 
		URI location = ServletUriComponentsBuilder			// create the uri
		.fromCurrentRequest()								// from the current url or request
		.path("/{id}")										// we add /{id} that is like the path variable
		.buildAndExpand(savedUser.getId()).toUri();			// we specify what is the path variable and convert to uri
		
		return ResponseEntity.created(location).build();	//ResponseEntity .created <- to return the status 201 created
	}
	
	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
//		if (user == null)
//			throw new UserNotFoundException("hola-"+id);
	}
}
