package com.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmsApplication.class, args);
		System.out.println("Hello Mr. Vikash");
		System.out.println("Welcome to the Hospital Management System SpringBoot Work");
	}

}
