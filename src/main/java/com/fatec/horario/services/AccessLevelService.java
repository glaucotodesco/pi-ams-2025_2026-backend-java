package com.fatec.horario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.horario.dtos.AccessLevelRequest;
import com.fatec.horario.dtos.AccessLevelResponse;
import com.fatec.horario.entities.AccessLevel;
import com.fatec.horario.mappers.AccessLevelMapper;
import com.fatec.horario.repositories.AccessLevelRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AccessLevelService {

    @Autowired
    private AccessLevelRepository repository;

    public List<AccessLevelResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(AccessLevelMapper::toDTO)
                .toList();
    }

    public AccessLevelResponse getById(Long id) {
        AccessLevel accessLevel = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AccessLevel not found with id " + id));

        return AccessLevelMapper.toDTO(accessLevel);
    }

    public AccessLevelResponse create(AccessLevelRequest request) {
        AccessLevel newAccessLevel = AccessLevelMapper.toEntity(request);
        AccessLevel saved = repository.save(newAccessLevel);

        return AccessLevelMapper.toDTO(saved);
    }

    public AccessLevelResponse update(Long id, AccessLevelRequest request) {
        AccessLevel existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AccessLevel not found with id " + id));

        existing.setLevel(request.level());
        existing.setDescription(request.description());

        AccessLevel updated = repository.save(existing);

        return AccessLevelMapper.toDTO(updated);
    }

    public void delete(Long id) {
        AccessLevel existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AccessLevel not found with id " + id));

        repository.delete(existing);
    }

}
