package com.nbenja.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nbenja.springboot")
public class SpringHateoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHateoasApplication.class, args);
	}
}
