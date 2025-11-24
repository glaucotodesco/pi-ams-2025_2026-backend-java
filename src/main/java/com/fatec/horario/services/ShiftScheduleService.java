package com.fatec.horario.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatec.horario.dto.shiftSchedule.ShiftScheduleRequest;
import com.fatec.horario.dto.shiftSchedule.ShiftScheduleResponse;
import com.fatec.horario.entities.ShiftSchedule;
import com.fatec.horario.mappers.ShiftScheduleMapper;
import com.fatec.horario.repositories.ShiftScheduleRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ShiftScheduleService {

    private final ShiftScheduleRepository shiftScheduleRepository;
    private final ShiftScheduleMapper shiftScheduleMapper;

    public ShiftScheduleService(
            ShiftScheduleRepository shiftScheduleRepository,
            ShiftScheduleMapper shiftScheduleMapper
    ) {
        this.shiftScheduleRepository = shiftScheduleRepository;
        this.shiftScheduleMapper = shiftScheduleMapper;
    }

    public List<ShiftScheduleResponse> getAll() {
        return shiftScheduleRepository.findAll()
                .stream()
                .map(shiftScheduleMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ShiftScheduleResponse getById(Long id) {
        ShiftSchedule entity = shiftScheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ShiftSchedule not found with id: " + id));

        return shiftScheduleMapper.toResponse(entity);
    }

    public ShiftScheduleResponse create(ShiftScheduleRequest dto) {
        ShiftSchedule entity = shiftScheduleMapper.toEntity(dto);
        ShiftSchedule saved = shiftScheduleRepository.save(entity);
        return shiftScheduleMapper.toResponse(saved);
    }

    public ShiftScheduleResponse update(Long id, ShiftScheduleRequest dto) {
        ShiftSchedule existing = shiftScheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ShiftSchedule not found with id: " + id));

        shiftScheduleMapper.updateEntityFromDto(dto, existing);

        ShiftSchedule updated = shiftScheduleRepository.save(existing);
        return shiftScheduleMapper.toResponse(updated);
    }

    public void delete(Long id) {
        ShiftSchedule existing = shiftScheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ShiftSchedule not found with id: " + id));

        shiftScheduleRepository.delete(existing);
    }
}
