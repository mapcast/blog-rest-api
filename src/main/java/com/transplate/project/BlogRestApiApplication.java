package com.transplate.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class BlogRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogRestApiApplication.class, args);
	}

}
