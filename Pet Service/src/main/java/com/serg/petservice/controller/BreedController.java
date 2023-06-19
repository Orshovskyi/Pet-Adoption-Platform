package com.serg.petservice.controller;

import com.serg.petservice.model.Breed;
import com.serg.petservice.service.BreedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/breeds")
public class BreedController {

    private final BreedService breedService;

    @GetMapping
    public ResponseEntity<List<Breed>> getAllBreeds() {
        List<Breed> breeds = breedService.getAllBreeds();
        return new ResponseEntity<>(breeds, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Breed> getBreedById(@PathVariable("id") Long id) {
        Breed breed = breedService.getBreedById(id);
        return new ResponseEntity<>(breed, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Breed> createBreed(@RequestBody Breed breed) {
        Breed savedBreed = breedService.saveBreed(breed);
        return new ResponseEntity<>(savedBreed, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Breed> updateBreed(@PathVariable("id") Long id, @RequestBody Breed breed) {
        breed.setId(id);
        Breed updatedBreed = breedService.saveBreed(breed);
        return new ResponseEntity<>(updatedBreed, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBreed(@PathVariable("id") Long id) {
        breedService.deleteBreed(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
