package com.example.rhproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class RhprojectApplication {

	public static void main(String[] args) {

		SpringApplication.run(RhprojectApplication.class, args);
	}

	@Autowired
	private FormationRepository UserRepo;
	 @Bean
	ApplicationRunner init ()
	 {
		 return (args)->{
			 UserRepo.save(new Formation("Angular","ggfff","ahmed",3));
		   UserRepo.findAll().forEach(System.out::println);
		 };
	 }
}
