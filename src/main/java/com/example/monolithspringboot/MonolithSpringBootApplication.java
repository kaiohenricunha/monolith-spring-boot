package com.example.monolithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.monolithspringboot.entity")
@EnableJpaRepositories(basePackages = "com.example.monolithspringboot.repository")
public class MonolithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonolithSpringBootApplication.class, args);
    }
}
