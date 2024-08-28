package com.numeroalpha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonManagementApiApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonManagementApiApplication.class);

	public static void main(String[] args) {
		logger.info("Starting the application...");
		SpringApplication.run(PersonManagementApiApplication.class, args);
		logger.info("Application Started...");
	}

}
