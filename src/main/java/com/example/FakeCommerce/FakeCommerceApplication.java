package com.example.FakeCommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  //Enables JPA Auditing, which allows for automatic population of auditing fields like createdAt and updatedAt in entities that extend BaseEntity.
public class FakeCommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FakeCommerceApplication.class, args);
    }
}
