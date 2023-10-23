package com.example.stagiairemsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StagiaireMsaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StagiaireMsaApplication.class, args);
    }

}
