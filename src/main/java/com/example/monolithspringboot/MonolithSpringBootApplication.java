package com.example.monolithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MonolithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonolithSpringBootApplication.class, args);
    }
}
