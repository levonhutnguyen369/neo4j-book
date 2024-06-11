package com.spring.ecommerce;

import org.neo4j.driver.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories

public class EcommerceApplication {
    private static Driver driver;
    private final ConfigurableApplicationContext applicationContext;

    public EcommerceApplication(Driver driver,ConfigurableApplicationContext applicationContext) {
        this.driver = driver;
        this.applicationContext = applicationContext;
    }


    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }


}
