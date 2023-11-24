package com.cricketcrickbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Hooks;

@SpringBootApplication
@EnableCaching
@RestController
public class CricketCrickBuzzApplication {

	@Bean
	public WebProperties.Resources getWResources(){
		return new WebProperties.Resources();
	}
	public static void main(String[] args) {
		Hooks.onOperatorDebug();
		SpringApplication.run(CricketCrickBuzzApplication.class, args);
	}

//	@GetMapping("/hi/{id}")
//	@Cacheable(value = "matches" , key = "#id")
//	public Employee get(@PathVariable Integer id){
//		System.out.println("Employee "+id);
//		return new Employee(id, "Abhishek Singh");
//	}
//
//	@GetMapping("/hi1/{id}")
//	@Cacheable(value = "matches" , key = "#id")
//	public ResponseEntity<Employee>   get1(@PathVariable Integer id){
//		System.out.println("Mono Employee "+id);
//		return new ResponseEntity<>(new Employee(id, "Abhishek Singh"), HttpStatus.OK);
//	}

}
