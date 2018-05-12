package com.jesus.rest.webservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

	// Versioning with path 
	@GetMapping("v1/person")							
	public PersonV1 personv1() {
		return new PersonV1("Jesus Monroy");
	}
	@GetMapping("v2/person")
	public PersonV2 personv2() {
		return new PersonV2(new Name("Jesus","Monroy"));
	}
	
	
	// Versioning with request param
	@GetMapping(value="/person", params="version=1")		
	public PersonV1 personParam1() {
		return new PersonV1("Jesus Monroy");
	}
	@GetMapping(value="/person", params="version=2")
	public PersonV2 personvParam2() {
		return new PersonV2(new Name("Jesus","Monroy"));
	}
	
	
	// Versioning with headers
	@GetMapping(value="/person/header", headers="API-VERSION=1")		
	public PersonV1 personHeader1() {
		return new PersonV1("Jesus Monroy");
	}
	@GetMapping(value="/person/header", headers="API-VERSION=2")
	public PersonV2 personvHeader2() {
		return new PersonV2(new Name("Jesus","Monroy"));
	}
	
	
	
	// Versioning with produces (also a header)
	// pero no funciona
//	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")		
//	public PersonV1 personProduces1() {
//		return new PersonV1("Jesus Monroy");
//	}
//	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
//	public PersonV2 personvProduces2() {
//		return new PersonV2(new Name("Jesus","Monroy"));
//	}
	
	
	
}
