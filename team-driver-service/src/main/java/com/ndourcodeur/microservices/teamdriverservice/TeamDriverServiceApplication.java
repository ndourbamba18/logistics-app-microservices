package com.ndourcodeur.microservices.teamdriverservice;

import com.ndourcodeur.microservices.teamdriverservice.entity.Driver;
import com.ndourcodeur.microservices.teamdriverservice.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient
public class TeamDriverServiceApplication {

	@Autowired
	private DriverRepository driverRepository;

	public static void main(String[] args) {

		SpringApplication.run(TeamDriverServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(DriverRepository driverRepository){
		return args -> {
			driverRepository.save(new Driver(null, "Bamba", "Ndour", "ndourbamba18@gmail.com", "+221 775847854", false, true));
			driverRepository.save(new Driver(null, "Maimouna", "Ndoye", "ndoyemaimouna@gmail.com", "+221 775420457", true, true));
			driverRepository.save(new Driver(null, "Soda", "Diop", "diopsoda@gmail.com", "+221 778942107", true, true));
			driverRepository.save(new Driver(null, "Aminata", "Camara", "camaraamina@gmail.com", "+211 775489521", true, true));
			driverRepository.findAll().forEach(driver -> {System.out.println(driver.getEmail());});
		};
	}

}
