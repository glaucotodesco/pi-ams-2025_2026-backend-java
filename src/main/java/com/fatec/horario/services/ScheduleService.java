package com.fatec.horario.services;

import java.util.List;

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

    public List<ScheduleResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(ScheduleMapper::toResponse)
                .toList();
    }

    public ScheduleResponse getById(Long id) {
        Schedule schedule = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + id));
        return ScheduleMapper.toResponse(schedule);
    }

    public ScheduleResponse create(ScheduleRequest request) {
        Schedule schedule = ScheduleMapper.toEntity(request);
        schedule = repository.save(schedule);
        return ScheduleMapper.toResponse(schedule);
    }

    public ScheduleResponse update(Long id, ScheduleRequest request) {
        Schedule schedule = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + id));

        schedule.setLessonNumber(request.lessonNumber());
        schedule.setWeekday(request.weekday());
        schedule = repository.save(schedule);
        return ScheduleMapper.toResponse(schedule);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Schedule not found with id: " + id);
        }
        repository.deleteById(id);
    }

}
