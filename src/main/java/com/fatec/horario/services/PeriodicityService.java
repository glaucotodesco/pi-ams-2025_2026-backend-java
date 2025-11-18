package com.fatec.horario.services;

import com.fatec.horario.repositories.PeriodicityRepository;
import com.fatec.horario.mappers.PeriodicityMapper;
import com.fatec.horario.dto.periodicity.PeriodicityRequest;
import com.fatec.horario.dto.periodicity.PeriodicityResponse;
import com.fatec.horario.entities.Periodicity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodicityService {

    private final PeriodicityRepository repository;
    private final PeriodicityMapper mapper;

    public PeriodicityService(PeriodicityRepository repository, PeriodicityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PeriodicityResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public PeriodicityResponse getById(Long id) {
        Periodicity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Periodicity not found with id: " + id));
        return mapper.toResponse(entity);
    }

    public PeriodicityResponse create(PeriodicityRequest dto) {
        Periodicity entity = mapper.toEntity(dto);
        Periodicity saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    public PeriodicityResponse update(Long id, PeriodicityRequest dto) {
        Periodicity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Periodicity not found with id: " + id));
        mapper.updateEntityFromDto(dto, entity);
        Periodicity saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Periodicity not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
