package com.example.restservice.api;

import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

//	http://localhost:8070/jac?course=db => example of query param
	@GetMapping("/jac")
	public String hello(@RequestParam(value="course", defaultValue = "Webservice") String courseName){
		return "hello students of the course " + courseName;
	}

	//http://localhost:8070/teacher/reza => pathparam
	@GetMapping("/teacher/{name}")
	public String teacherName(@PathVariable String name){
		return "the teacher name = " + name;
	}

	//create a class Student => id and name
	//create 2 routes
	// "/welcome" that has query param of a name
	//"/welcome/name => path variable


	//requestparam
	//pathparam
	//https://www.kijiji.ca/h-grand-montreal/80002?siteLocale=en_CA
	//https://www.kijiji.ca -> host
	//h-grand-montreal/80002 => pathparam /{string}/{int}
	//?siteLocale=en_CA => queryparam RequestParam


	//GET
	//POST
	//PUT
	//DELETE

}
