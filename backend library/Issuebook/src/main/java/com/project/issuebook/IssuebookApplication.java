package com.project.issuebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class IssuebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssuebookApplication.class, args);
	}
	
//	@LoadBalanced
	@Bean
	public RestTemplate getTemplate(){
		return new RestTemplate();
	}

}
