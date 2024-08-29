package com.yevhenpiven.bootstrapproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "entity")
public class BootstrapprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapprojectApplication.class, args);
    }
}
