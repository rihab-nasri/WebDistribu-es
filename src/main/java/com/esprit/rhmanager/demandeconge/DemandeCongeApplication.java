package com.esprit.rhmanager.demandeconge;

import com.esprit.rhmanager.demandeconge.Entities.DemandeConge;
import com.esprit.rhmanager.demandeconge.Repository.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;




@SpringBootApplication
@EnableEurekaClient
public class DemandeCongeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemandeCongeApplication.class, args);
    }

    @Autowired
    private CongeRepository congeRepository;

    @Bean
    ApplicationRunner init(){
        return (args) -> {
            congeRepository.save(new DemandeConge("bouga"));

            congeRepository.findAll().forEach(System.out::println);

        };
    }
}
