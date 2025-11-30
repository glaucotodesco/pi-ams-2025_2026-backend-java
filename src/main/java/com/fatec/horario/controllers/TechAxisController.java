package com.fatec.horario.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.horario.dtos.TechAxisRequest;
import com.fatec.horario.dtos.TechAxisResponse;
import com.fatec.horario.services.TechAxisService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tech-axis")
@CrossOrigin
public class TechAxisController {

    @Autowired
    private TechAxisService service;

    // GET - Find all tech axis
    // http://localhost:8080/tech-axis
    @GetMapping
    public ResponseEntity<List<TechAxisResponse>> getAllTechAxis() {
        List<TechAxisResponse> list = service.getAllTechAxis();
        return ResponseEntity.ok(list);
    }

    // GET - Find tech axis by ID
    // http://localhost:8080/tech-axis/1
    @GetMapping("/{id}")
    public ResponseEntity<TechAxisResponse> getTechAxisById(@PathVariable Long id) {
        TechAxisResponse response = service.getTechAxisById(id);
        return ResponseEntity.ok(response);
    }

    // POST - Create new tech axis
    // http://localhost:8080/tech-axis
    @PostMapping
    public ResponseEntity<TechAxisResponse> createTechAxis(
            @Valid @RequestBody TechAxisRequest request) {

        TechAxisResponse response = service.createTechAxis(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    // PUT - Update tech axis
    // http://localhost:8080/tech-axis/1
    @PutMapping("/{id}")
    public ResponseEntity<TechAxisResponse> updateTechAxis(
            @PathVariable Long id,
            @Valid @RequestBody TechAxisRequest request) {

        TechAxisResponse response = service.updateTechAxis(id, request);
        return ResponseEntity.ok(response);
    }

    // DELETE - Delete tech axis
    // http://localhost:8080/tech-axis/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechAxis(@PathVariable Long id) {
        service.deleteTechAxis(id);
        return ResponseEntity.noContent().build();
    }
}

