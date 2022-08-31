package com.example.authorbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthorbookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorbookServiceApplication.class, args);
    }

}
