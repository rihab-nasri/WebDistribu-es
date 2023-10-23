package com.sprintservice;

import com.sprintservice.entity.SprintEntity;
import com.sprintservice.entity.SprintEnum;
import com.sprintservice.service.SprintService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.sprintservice.openfeign")
public class SprintServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprintServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(SprintService sprintService) {
        return args -> {
            sprintService.addSprint(new SprintEntity(1, new Date(), new Date(), "Sprint 1", true, SprintEnum.VALID, 1L, null));
            sprintService.addSprint(new SprintEntity(2, new Date(), new Date(), "Sprint 2", true, SprintEnum.VALID, 1L, null));
            sprintService.addSprint(new SprintEntity(3, new Date(), new Date(), "Sprint 3", true, SprintEnum.VALID, 1L, null));
        };
    }
}
