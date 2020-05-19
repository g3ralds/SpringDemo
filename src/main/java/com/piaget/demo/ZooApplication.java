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

//	@Bean
//	public CommandLineRunner demo(AnimalRepository repository) {
//		return (args) -> {
//			repository.save(new Animal("Bugs", "Bunny"));
//			repository.save(new Animal("Tom", "Cat"));
//			repository.save(new Animal("Jerry", "Mouse"));
//			repository.save(new Animal("Silvester", "Cat"));
//			repository.save(new Animal("Tweety", "Canary"));
//
//			log.info("Logging all animals using findAll()");
//			for (Animal animal : repository.findAll()) {
//				log.info(animal.toString());
//			}
//			log.info("---------------------");
//
//			Animal animal = repository.findById(1L);
//			log.info("Animal retrieved using findById(1L)");
//			log.info(animal.toString());
//			log.info("---------------------");
//
//			log.info("Animal retrieved using findBySpecies(\"Cat\")");
//			repository.findBySpecies("Cat").forEach(cat -> {
//				log.info(cat.toString());
//			});
//
//			log.info("---------------------");
//		};
//	}
}
