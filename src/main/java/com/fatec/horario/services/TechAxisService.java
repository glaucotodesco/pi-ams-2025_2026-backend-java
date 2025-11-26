package com.fatec.horario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.horario.dtos.TechAxisRequest;
import com.fatec.horario.dtos.TechAxisResponse;
import com.fatec.horario.entities.TechAxis;
import com.fatec.horario.mappers.TechAxisMapper;
import com.fatec.horario.repositories.TechAxisRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TechAxisService {

    @Autowired
    private TechAxisRepository repository;

    public TechAxisResponse getById(Long id) {
        TechAxis entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TechAxis not found with id: " + id));

        return TechAxisMapper.toResponse(entity);
    }

    public List<TechAxisResponse> getAll() {
        return repository.findAll().stream()
                .map(TechAxisMapper::toResponse)
                .toList();
    }

    public TechAxisResponse create(TechAxisRequest dto) {
        TechAxis entity = TechAxisMapper.toEntity(dto);
        TechAxis saved = repository.save(entity);
        return TechAxisMapper.toResponse(saved);
    }

    public TechAxisResponse update(Long id, TechAxisRequest dto) {
        TechAxis entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TechAxis not found with id: " + id));

        entity.setName(dto.name());

        TechAxis updated = repository.save(entity);

        return TechAxisMapper.toResponse(updated);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("TechAxis not found with id: " + id);
        }

        repository.deleteById(id);
    }
}
