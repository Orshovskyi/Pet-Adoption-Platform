package com.serg.petservice.repository;

import com.serg.petservice.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<Breed, Long> {
}
