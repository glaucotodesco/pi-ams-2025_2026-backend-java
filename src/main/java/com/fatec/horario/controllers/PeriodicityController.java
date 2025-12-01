package com.fatec.horario.controllers;

import com.fatec.horario.dtos.PeriodicityRequest;
import com.fatec.horario.dtos.PeriodicityResponse;
import com.fatec.horario.services.PeriodicityService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/periodicities")
@CrossOrigin
public class PeriodicityController {

    @Autowired
    private PeriodicityService service;

    @GetMapping
    public ResponseEntity<List<PeriodicityResponse>> getAllPeriodicities() {
        List<PeriodicityResponse> periodicities = service.getAll();
        return ResponseEntity.ok(periodicities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodicityResponse> getPeriodicityById(@PathVariable Long id) {
        PeriodicityResponse periodicity = service.getById(id);
        return ResponseEntity.ok(periodicity);
    }

    @PostMapping
    public ResponseEntity<PeriodicityResponse> createPeriodicity(
            @Valid @RequestBody PeriodicityRequest request) {

        PeriodicityResponse created = service.create(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.id())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodicityResponse> updatePeriodicity(
            @PathVariable Long id,
            @Valid @RequestBody PeriodicityRequest request) {

        PeriodicityResponse updated = service.update(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeriodicity(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
