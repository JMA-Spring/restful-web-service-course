package com.jesus.rest.webservice.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue retriveBean() {
		
		// The bean to be returned, it also can be a list or whatever
		SomeBean bean = new SomeBean("value 1", "value 2", "cool", "well done");

		// the filter where we specify the only attributes we want to show
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value4");

		// Filter provided, creates the filter declared before with the specified name
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);

		// creates a mapping that contiand the ben to be returned and the filter that is going to be applied
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;
	}

}
