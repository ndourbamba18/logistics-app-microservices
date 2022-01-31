package com.ndourcodeur.microservices.prequalifynowservice;
import com.ndourcodeur.microservices.prequalifynowservice.repository.PreQualifyDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PreQualifyNowServiceApplication {

	@Autowired
	private PreQualifyDriverRepository preQualifyDriverRepository;

	public static void main(String[] args) {
		SpringApplication.run(PreQualifyNowServiceApplication.class, args);
	}

}
