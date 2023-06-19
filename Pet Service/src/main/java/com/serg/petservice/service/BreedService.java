package com.serg.petservice.service;

import com.serg.petservice.exception.NotFoundException;
import com.serg.petservice.model.Breed;
import com.serg.petservice.repository.BreedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BreedService {

    private final BreedRepository breedRepository;

    public List<Breed> getAllBreeds() {
        return breedRepository.findAll();
    }

    public Breed getBreedById(Long breedId) {
        return breedRepository.findById(breedId)
                .orElseThrow(() -> new NotFoundException("Breed not found with id: " + breedId));
    }

    public Breed saveBreed(Breed breed) {
        return breedRepository.save(breed);
    }

    public void deleteBreed(Long breedId) {
        Breed breed = getBreedById(breedId);
        breedRepository.delete(breed);
    }
}
