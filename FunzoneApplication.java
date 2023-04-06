package com.corycosby.funzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Defines a public class called FunzoneApplication 
@SpringBootApplication   //sets up the basic Spring Boot configuration
public class FunzoneApplication {

	// Main method to start the program
	public static void main(String[] args) {
		
		SpringApplication.run(FunzoneApplication.class, args);
	}

}

