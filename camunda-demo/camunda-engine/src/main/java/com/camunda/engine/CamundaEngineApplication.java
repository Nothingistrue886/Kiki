package com.camunda.engine;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableProcessApplication
@SpringBootApplication
public class CamundaEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamundaEngineApplication.class, args);
    }

}
