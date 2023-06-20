package com.serg.petservice.service;

import com.serg.petservice.exception.NotFoundException;
import com.serg.petservice.model.Pet;
import com.serg.petservice.model.PetStatus;
import com.serg.petservice.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PetService {

    private final PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetById(Long petId) {
        return petRepository.findById(petId)
                .orElseThrow(() -> new NotFoundException("Pet not found with id: " + petId));
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public void deletePet(Long petId) {
        Pet pet = getPetById(petId);
        petRepository.delete(pet);
    }

    @Transactional
    public void updatePetStatus(Long petId, PetStatus status) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new NotFoundException("Pet not found"));

        pet.setStatus(status);
        petRepository.save(pet);
    }
}
