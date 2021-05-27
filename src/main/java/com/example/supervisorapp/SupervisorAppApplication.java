package com.example.supervisorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SupervisorAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupervisorAppApplication.class, args);
    }

}
