package com.serg.petservice.repository;

import com.serg.petservice.model.Specie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecieRepository extends JpaRepository<Specie, Long> {
}
