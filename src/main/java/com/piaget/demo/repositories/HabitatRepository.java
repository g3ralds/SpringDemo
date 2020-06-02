package com.piaget.demo.repositories;

import com.piaget.demo.entities.Habitat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HabitatRepository extends CrudRepository<Habitat, Long> {
    Habitat findById(long id);
    List<Habitat> findAll();
}