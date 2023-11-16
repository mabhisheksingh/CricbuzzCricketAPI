package com.cricketcrickbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CricketCrickBuzzApplication {

	@Bean
	public WebProperties.Resources get(){
		return new WebProperties.Resources();
	}
	public static void main(String[] args) {
		SpringApplication.run(CricketCrickBuzzApplication.class, args);
	}

}
