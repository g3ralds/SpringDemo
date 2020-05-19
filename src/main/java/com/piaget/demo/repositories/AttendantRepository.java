package com.piaget.demo.repositories;

import com.piaget.demo.entities.Attendant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Create
// Read
// Update
// Delete

public interface AttendantRepository extends CrudRepository<Attendant, Long> {
    public List<Attendant> findByEmail(String email);
}
