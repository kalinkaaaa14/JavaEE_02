package com.example.hw02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Hw02Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw02Application.class, args);
	}

}
