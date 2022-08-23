package com.cognizant.microservices.pensionerdetailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PensionerDetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailServiceApplication.class, args);
	}

}
