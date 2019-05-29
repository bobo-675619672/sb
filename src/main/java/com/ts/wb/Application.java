package com.ts.wb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableSwagger2
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}  
}