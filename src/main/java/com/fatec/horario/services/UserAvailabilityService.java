package com.fatec.horario.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatec.horario.dtos.UserAvailabilityRequest;
import com.fatec.horario.dtos.UserAvailabilityResponse;
import com.fatec.horario.entities.UserAvailability;
import com.fatec.horario.mappers.UserAvailabilityMapper;
import com.fatec.horario.repositories.UserAvailabilityRepository;

@Service
public class UserAvailabilityService {

    private UserAvailabilityRepository repository;

    public List<UserAvailabilityResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(UserAvailabilityMapper::toResponse)
                .collect(Collectors.toList());
    }

    public UserAvailabilityResponse getById(Long id) {
        UserAvailability userAvailability = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserAvailability not found with id " + id));

        return UserAvailabilityMapper.toResponse(userAvailability);
    }

    public UserAvailabilityResponse create(UserAvailabilityRequest dto) {
        UserAvailability entity = UserAvailabilityMapper.toEntity(dto);
        UserAvailability saved = repository.save(entity);

        return UserAvailabilityMapper.toResponse(saved);
    }

    public UserAvailabilityResponse update(Long id, UserAvailabilityRequest dto) {
        UserAvailability existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserAvailability not found with id " + id));

        existing.setWeekday(dto.weekday());
        existing.setLessonNumber(dto.lessonNumber());

        UserAvailability updated = repository.save(existing);

        return UserAvailabilityMapper.toResponse(updated);
    }

    public void delete(Long id) {
        UserAvailability existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserAvailability not found with id " + id));

        repository.delete(existing);
    }
}
