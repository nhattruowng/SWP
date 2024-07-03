package com.example.booking88be.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "com.example.booking88be.entity")
@EnableJpaRepositories(basePackages = "com.example.booking88be.repository")
@ComponentScan(basePackages = {"com.example.booking88be"})//"swp.booking.booking88be.demo"
public class Booking88beApplication {

    public static void main(String[] args) {
        SpringApplication.run(Booking88beApplication.class, args);
    }
}
