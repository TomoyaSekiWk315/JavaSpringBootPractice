package com.udemy.spring2item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Spring2itemApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring2itemApplication.class, args);
	}

}
