package com.serg.petservice.service;

import com.serg.petservice.exception.NotFoundException;
import com.serg.petservice.model.Specie;
import com.serg.petservice.repository.SpecieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SpecieService {

    private final SpecieRepository speciesRepository;

    public List<Specie> getAllSpecies() {
        return speciesRepository.findAll();
    }

    public Specie getSpeciesById(Long speciesId) {
        return speciesRepository.findById(speciesId)
                .orElseThrow(() -> new NotFoundException("Species not found with id: " + speciesId));
    }

    public Specie saveSpecies(Specie species) {
        return speciesRepository.save(species);
    }

    public void deleteSpecies(Long speciesId) {
        Specie species = getSpeciesById(speciesId);
        speciesRepository.delete(species);
    }
}
