package br.com.spingboot.jdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
public class Application {
	
    public static void main(String[] args) {
    	
        SpringApplication.run(Application.class, args); /*É a linha principal que roda o projeto Spring Boot */
    }
}
