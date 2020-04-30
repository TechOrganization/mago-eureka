package com.mango.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaServer
public class MangoEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangoEurekaApplication.class, args);
    }
}
