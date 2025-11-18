package com.fatec.horario.mappers;

import com.fatec.horario.dto.periodicity.PeriodicityRequest;
import com.fatec.horario.dto.periodicity.PeriodicityResponse;
import com.fatec.horario.entities.Periodicity;
import org.springframework.stereotype.Component;

@Component
public class PeriodicityMapper {

    public Periodicity toEntity(PeriodicityRequest request) {
        if (request == null) return null;
        Periodicity entity = new Periodicity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }

    public PeriodicityResponse toResponse(Periodicity entity) {
        if (entity == null) return null;
        return new PeriodicityResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }

    public void updateEntityFromDto(PeriodicityRequest request, Periodicity entity) {
        if (request == null || entity == null) return;
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
    }
}
