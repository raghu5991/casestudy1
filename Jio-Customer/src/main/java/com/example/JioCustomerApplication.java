package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.example")
public class JioCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JioCustomerApplication.class, args);
	}

}
