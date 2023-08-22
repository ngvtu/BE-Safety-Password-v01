package com.example.besafetypassv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BeSafetyPassApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeSafetyPassApplication.class, args);
    }

}
