package com.fatec.horario.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.horario.dtos.ClassGroupRequest;
import com.fatec.horario.dtos.ClassGroupResponse;
import com.fatec.horario.services.ClassGroupService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/class-groups")
@CrossOrigin
public class ClassGroupController {

    private final ClassGroupService service;

    public ClassGroupController(ClassGroupService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClassGroupResponse>> getAll() {
        List<ClassGroupResponse> groups = service.getAll();
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassGroupResponse> getById(@PathVariable Long id) {
        ClassGroupResponse group = service.getById(id);
        return ResponseEntity.ok(group);
    }

    @PostMapping
    public ResponseEntity<ClassGroupResponse> create(
            @Valid @RequestBody ClassGroupRequest request) {

        ClassGroupResponse group = service.saveClassGroup(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(group.id())
                .toUri();

        return ResponseEntity.created(location).body(group);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassGroupResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ClassGroupRequest request) {

        service.update(request, id);
        ClassGroupResponse group = service.getById(id);
        return ResponseEntity.ok(group);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}