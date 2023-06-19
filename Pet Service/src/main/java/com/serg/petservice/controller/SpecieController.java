package com.serg.petservice.controller;

import com.serg.petservice.model.Specie;
import com.serg.petservice.service.SpecieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/species")
public class SpecieController {

    private final SpecieService specieService;

    @GetMapping
    public ResponseEntity<List<Specie>> getAllSpecies() {
        List<Specie> species = specieService.getAllSpecies();
        return new ResponseEntity<>(species, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specie> getSpeciesById(@PathVariable("id") Long id) {
        Specie species = specieService.getSpeciesById(id);
        return new ResponseEntity<>(species, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Specie> createSpecies(@RequestBody Specie species) {
        Specie savedSpecies = specieService.saveSpecies(species);
        return new ResponseEntity<>(savedSpecies, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specie> updateSpecies(@PathVariable("id") Long id, @RequestBody Specie species) {
        species.setId(id);
        Specie updatedSpecies = specieService.saveSpecies(species);
        return new ResponseEntity<>(updatedSpecies, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecies(@PathVariable("id") Long id) {
        specieService.deleteSpecies(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
