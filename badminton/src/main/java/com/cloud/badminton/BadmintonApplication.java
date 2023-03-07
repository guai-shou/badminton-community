package com.cloud.badminton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BadmintonApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadmintonApplication.class, args);
    }

}
