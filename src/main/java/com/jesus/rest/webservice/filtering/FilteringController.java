package com.jesus.rest.webservice.filtering;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retriveBean() {
		return new SomeBean("value 1", "value 2","cool","well done");
	}

}
