package com.bridgelabz.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class WorkshopProblemStatementApplication {

	public static void main(String[] args) {
		log.debug("User register app running");
		SpringApplication.run(WorkshopProblemStatementApplication.class, args);
	}

}
