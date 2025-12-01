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

import com.fatec.horario.dtos.ShiftScheduleRequest;
import com.fatec.horario.dtos.ShiftScheduleResponse;
import com.fatec.horario.services.ShiftScheduleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/shift-schedules")
@CrossOrigin
public class ShiftScheduleController {

    @Autowired
    private ShiftScheduleService service;

    // GET - Get all shift schedules
    @GetMapping
    public ResponseEntity<List<ShiftScheduleResponse>> getAllShiftSchedules() {
        List<ShiftScheduleResponse> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    // GET - Get shift schedule by ID
    @GetMapping("/{id}")
    public ResponseEntity<ShiftScheduleResponse> getShiftScheduleById(@PathVariable Long id) {
        ShiftScheduleResponse response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    // POST - Create new shift schedule
    @PostMapping
    public ResponseEntity<ShiftScheduleResponse> createShiftSchedule(
            @Valid @RequestBody ShiftScheduleRequest request) {

        ShiftScheduleResponse response = service.create(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    // PUT - Update shift schedule by ID
    @PutMapping("/{id}")
    public ResponseEntity<ShiftScheduleResponse> updateShiftSchedule(
            @PathVariable Long id,
            @Valid @RequestBody ShiftScheduleRequest request) {

        ShiftScheduleResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    // DELETE - Delete shift schedule by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShiftSchedule(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
