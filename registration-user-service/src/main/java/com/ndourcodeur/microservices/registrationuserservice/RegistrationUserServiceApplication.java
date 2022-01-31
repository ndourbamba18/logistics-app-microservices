package com.ndourcodeur.microservices.registrationuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
@EnableEurekaClient
public class RegistrationUserServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(RegistrationUserServiceApplication.class, args);
	}

}
