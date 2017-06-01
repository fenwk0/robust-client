package com.macymoo.robustclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class RobustClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobustClientApplication.class, args);
	}
}


