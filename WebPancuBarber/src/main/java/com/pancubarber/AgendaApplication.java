package com.pancubarber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgendaApplication {

    public static void main(String[] args) {
        // Este comando arranca todo el sistema de la barbería
        SpringApplication.run(AgendaApplication.class, args);
    }

}