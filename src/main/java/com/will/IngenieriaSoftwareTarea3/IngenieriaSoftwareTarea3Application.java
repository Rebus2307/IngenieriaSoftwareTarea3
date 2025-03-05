package com.will.IngenieriaSoftwareTarea3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.will.IngenieriaSoftwareTarea3.auth.config",
    "com.will.IngenieriaSoftwareTarea3.auth.controller",
    "com.will.IngenieriaSoftwareTarea3.auth.entity",
    "com.will.IngenieriaSoftwareTarea3.auth.repository",
    "com.will.IngenieriaSoftwareTarea3.auth.service",
    "com.will.IngenieriaSoftwareTarea3.auth.SistemaAutenticacion"
})
@EnableJpaRepositories(basePackages = "com.will.IngenieriaSoftwareTarea3.auth.repository")
@EntityScan(basePackages = "com.will.IngenieriaSoftwareTarea3.auth.entity")
public class IngenieriaSoftwareTarea3Application {
    public static void main(String[] args) {
        SpringApplication.run(IngenieriaSoftwareTarea3Application.class, args);
    }
}