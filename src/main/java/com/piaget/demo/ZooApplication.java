package com.piaget.demo;

import com.piaget.demo.entities.Animal;
import com.piaget.demo.repositories.AnimalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZooApplication {

	private static final Logger log = LoggerFactory.getLogger(ZooApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ZooApplication.class, args);
	}

}
