package com.fatec.horario.services;

import com.fatec.horario.dtos.UserAvailabilityRequest;
import com.fatec.horario.dtos.UserAvailabilityResponse;
import com.fatec.horario.entities.User;
import com.fatec.horario.entities.UserAvailability;
import com.fatec.horario.mappers.UserAvailabilityMapper;
import com.fatec.horario.repositories.UserAvailabilityRepository;
import com.fatec.horario.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAvailabilityService {

    private final UserAvailabilityRepository repository;
    private final UserRepository userRepository;
    private final UserAvailabilityMapper mapper;

    // GET ALL
    public List<UserAvailabilityResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    // GET BY ID
    public UserAvailabilityResponse getById(Long id) {
        UserAvailability ua = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserAvailability not found with id: " + id));
        return mapper.toResponse(ua);
    }

    // CREATE
    public UserAvailabilityResponse create(UserAvailabilityRequest dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + dto.getUserId()));

        UserAvailability entity = mapper.toEntity(dto);
        entity.setUser(user);

        UserAvailability saved = repository.save(entity);

        return mapper.toResponse(saved);
    }

    // UPDATE
    public UserAvailabilityResponse update(Long id, UserAvailabilityRequest dto) {

        UserAvailability ua = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserAvailability not found with id: " + id));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + dto.getUserId()));

        ua.setUser(user);
        ua.setDate(dto.getDate());
        ua.setStartTime(dto.getStartTime());
        ua.setEndTime(dto.getEndTime());
        ua.setDescription(dto.getDescription());

        UserAvailability updated = repository.save(ua);

        return mapper.toResponse(updated);
    }

    // DELETE
    public void delete(Long id) {
        UserAvailability ua = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserAvailability not found with id: " + id));
        repository.delete(ua);
    }
}
