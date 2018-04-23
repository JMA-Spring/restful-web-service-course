package com.jesus.rest.webservice.helloworld;

public class HelloWorldBean {		// POJO
	private String message;
	private String name;
	private EmbeddedBean bean;		// when it is sendded by the controller as JSON, also sends the embedded beans

	public HelloWorldBean(String message) {
		this.message = message;
		this.name = "hola";
		this.bean = new EmbeddedBean(2);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmbeddedBean getBean() {
		return bean;
	}

	public void setBean(EmbeddedBean bean) {
		this.bean = bean;
	}
	
	
	
	
	
	
	

}
