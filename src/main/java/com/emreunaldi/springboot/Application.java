package com.emreunaldi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Security inactive
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)

// Security Active
//@SpringBootApplication
// Auditing
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
