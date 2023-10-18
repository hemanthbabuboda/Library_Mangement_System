package com.example.bookList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookListApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookListApplication.class, args);
	}

}
