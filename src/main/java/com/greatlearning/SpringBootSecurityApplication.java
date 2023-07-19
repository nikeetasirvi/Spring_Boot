package com.greatlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Spring Boot Security Application",contact=@Contact(email="admin@gmail.com")))
public class SpringBootSecurityApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

}
