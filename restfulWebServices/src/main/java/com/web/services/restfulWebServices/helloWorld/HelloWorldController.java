package com.web.services.restfulWebServices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
	
	//GET
	//URI - /hello-world
	//method - "Hello World"
	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	//@GetMapping(path="/hello-world")
	//@PostMapping
	//@PutMapping
	public String helloWorld() {
		return "Hello World Spring Cloud Micro services";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Spring Cloud Micro services");
	}
	
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World Spring Cloud Micro services, "+name);
	}
	
}
