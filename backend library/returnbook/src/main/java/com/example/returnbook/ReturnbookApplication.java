package com.example.returnbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableFeignClients
@EnableDiscoveryClient

public class ReturnbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReturnbookApplication.class, args);
	}

	@Bean
	public RestTemplate getTemplate(){
		return new RestTemplate();
	}

}
