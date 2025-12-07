package com.javalearning.employeemanagemnetsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EmployeemanagemnetsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagemnetsystemApplication.class, args);
	}

}
