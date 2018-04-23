package com.jesus.rest.webservice.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controller
public class helloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	// @GetMapping(path = "hello-world") // es lo mismo pero pone directamente el get
	public String helloWorld() {
		return "Hello world";
	}

	@GetMapping(path = "hello-world-bean") // es lo mismo pero pone directamente el get
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world");		// Si envias un bean, te regresa en json todos sus atributos
	}
	
	@GetMapping(path = "hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world %s",name));
	}
	
	@GetMapping(path = "hello-world-bean/international")
	public String helloWorldBeanInternational() {
		//return messageSource.getMessage("good.morning.message", null, locale); 		// passing the locale int he header
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale()); //getting automaticaly
	}

}
