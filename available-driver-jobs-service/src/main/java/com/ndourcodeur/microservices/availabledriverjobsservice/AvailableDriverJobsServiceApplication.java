package com.ndourcodeur.microservices.availabledriverjobsservice;

import com.ndourcodeur.microservices.availabledriverjobsservice.entity.AvailableDriver;
import com.ndourcodeur.microservices.availabledriverjobsservice.repository.AvailableDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
public class AvailableDriverJobsServiceApplication {

	@Autowired
	private AvailableDriverRepository availableDriverRepository;

	public static void main(String[] args) {
		SpringApplication.run(AvailableDriverJobsServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AvailableDriverRepository availableDriverRepository){
		return args -> {
			availableDriverRepository.save(new AvailableDriver(null, "CDL Driver Instructor Savannah, GA", "844-946-2520", "$69,000", "$79,000", "Weekly", "$1,000 Weekly", "Call for details", "Average is for Other People -  Dedicated Dollar General Traditional fleet available in Lebec, CA with home weekly and pass-through opportunities available! Hauling traditional Dollar General freight in dry van trailers with liftgates out of Lebec, CA to stores in CA, AZ, OR, NV, UT, and CO. Ave..."));
			availableDriverRepository.save(new AvailableDriver(null, "Crane Logistics", "844-946-2520", "$69,000", "$79,000", "Weekly", "$1,000 Weekly", "Call for details", "Average is for Other People -  Dedicated Dollar General Traditional fleet available in Lebec, CA with home weekly and pass-through opportunities available! Hauling traditional Dollar General freight in dry van trailers with liftgates out of Lebec, CA to stores in CA, AZ, OR, NV, UT, and CO. Ave...Average is for Other People -  Dedicated Dollar General Traditional fleet available in Lebec, CA with home weekly and pass-through opportunities available! Hauling traditional Dollar General freight in dry van trailers with liftgates out of Lebec, CA to stores in CA, AZ, OR, NV, UT, and CO. Ave..."));
			availableDriverRepository.save(new AvailableDriver(null, "Dollar General Lebec, CA", "844-946-2520", "$69,000", "$79,000", "Weekly", "$1,000 Weekly", "Call for details", "Average is for Other People -  Dedicated Dollar General Traditional fleet available in Lebec, CA with home weekly and pass-through opportunities available! Hauling traditional Dollar General freight in dry van trailers with liftgates out of Lebec, CA to stores in CA, AZ, OR, NV, UT, and CO. Ave..."));
			availableDriverRepository.save(new AvailableDriver(null, "Temperature Controlled Fleet", "844-946-2520", "$69,000", "$79,000", "Weekly", "$1,000 Weekly", "Call for details", "Average is for Other People -  Dedicated Dollar General Traditional fleet available in Lebec, CA with home weekly and pass-through opportunities available! Hauling traditional Dollar General freight in dry van trailers with liftgates out of Lebec, CA to stores in CA, AZ, OR, NV, UT, and CO. Ave..."));
			availableDriverRepository.save(new AvailableDriver(null, "Tractor Supply Whitestown, IN", "844-946-2520", "$69,000", "$79,000", "Weekly", "$1,000 Weekly", "Call for details", "Average is for Other People -  Dedicated Dollar General Traditional fleet available in Lebec, CA with home weekly and pass-through opportunities available! Hauling traditional Dollar General freight in dry van trailers with liftgates out of Lebec, CA to stores in CA, AZ, OR, NV, UT, and CO. Ave..."));
			availableDriverRepository.save(new AvailableDriver(null, "Regional - Salt Lake City, UT", "844-946-2520", "$69,000", "$79,000", "Weekly", "$1,000 Weekly", "Call for details", "Average is for Other People -  Dedicated Dollar General Traditional fleet available in Lebec, CA with home weekly and pass-through opportunities available! Hauling traditional Dollar General freight in dry van trailers with liftgates out of Lebec, CA to stores in CA, AZ, OR, NV, UT, and CO. Ave..."));
			availableDriverRepository.save(new AvailableDriver(null, "White Glove In-Home Driver, Cranbury, NJ", "844-946-2520", "$69,000", "$79,000", "Weekly", "$1,000 Weekly", "Call for details", "Average is for Other People -  Dedicated Dollar General Traditional fleet available in Lebec, CA with home weekly and pass-through opportunities available! Hauling traditional Dollar General freight in dry van trailers with liftgates out of Lebec, CA to stores in CA, AZ, OR, NV, UT, and CO. Ave..."));
			availableDriverRepository.save(new AvailableDriver(null, "CDL Driver Instructor Columbus, OH", "844-946-2520", "$69,000", "$79,000", "Weekly", "$1,000 Weekly", "Call for details", "Average is for Other People -  Dedicated Dollar General Traditional fleet available in Lebec, CA with home weekly and pass-through opportunities available! Hauling traditional Dollar General freight in dry van trailers with liftgates out of Lebec, CA to stores in CA, AZ, OR, NV, UT, and CO. Ave...Average is for Other People -  Dedicated Dollar General Traditional fleet available in Lebec, CA with home weekly and pass-through opportunities available! Hauling traditional Dollar General freight in dry van trailers with liftgates out of Lebec, CA to stores in CA, AZ, OR, NV, UT, and CO. Ave..."));
			availableDriverRepository.save(new AvailableDriver(null, "Walmart Olney, IL", "844-946-2520", "$69,000", "$79,000", "Weekly", "$1,000 Weekly", "Call for details", "Average is for Other People -  Dedicated Dollar General Traditional fleet available in Lebec, CA with home weekly and pass-through opportunities available! Hauling traditional Dollar General freight in dry van trailers with liftgates out of Lebec, CA to stores in CA, AZ, OR, NV, UT, and CO. Ave..."));
		};
	}
}
