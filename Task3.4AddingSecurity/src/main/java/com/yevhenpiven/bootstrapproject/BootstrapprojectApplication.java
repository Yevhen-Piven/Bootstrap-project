package com.yevhenpiven.bootstrapproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { ErrorMvcAutoConfiguration.class })
@ComponentScan
public class BootstrapprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapprojectApplication.class, args);
    }
}
