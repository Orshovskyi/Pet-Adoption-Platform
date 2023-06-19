package com.serg.petservice.controller;

import com.serg.petservice.model.Pet;
import com.serg.petservice.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable("id") Long id) {
        Pet pet = petService.getPetById(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        Pet savedPet = petService.savePet(pet);
        return new ResponseEntity<>(savedPet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable("id") Long id, @RequestBody Pet pet) {
        pet.setId(id);
        Pet updatedPet = petService.savePet(pet);
        return new ResponseEntity<>(updatedPet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable("id") Long id) {
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
