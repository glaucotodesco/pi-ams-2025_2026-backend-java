package com.fatec.horario.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.horario.dtos.ScheduleRequest;
import com.fatec.horario.dtos.ScheduleResponse;
import com.fatec.horario.entities.Schedule;
import com.fatec.horario.mappers.ScheduleMapper;
import com.fatec.horario.repositories.ScheduleRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Autowired
    private ScheduleMapper mapper;

    public List<ScheduleResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ScheduleResponse getById(Long id) {
        Schedule schedule = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + id));

        return mapper.toDTO(schedule);
    }

    public ScheduleResponse create(ScheduleRequest dto) {
        Schedule schedule = mapper.toEntity(dto);
        Schedule saved = repository.save(schedule);
        return mapper.toDTO(saved);
    }

    public ScheduleResponse update(Long id, ScheduleRequest dto) {
        Schedule schedule = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + id));

        schedule.setLessonNuumber(dto.lessonNumber());
        schedule.setWeekday(dto.weekday());

        Schedule updated = repository.save(schedule);
        return mapper.toDTO(updated);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Schedule not found with id: " + id);
        }
        repository.deleteById(id);
    }

}
