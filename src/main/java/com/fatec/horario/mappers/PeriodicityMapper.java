package com.fatec.horario.mappers;

import com.fatec.horario.entities.Periodicity;
import com.fatec.horario.dtos.PeriodicityRequest;
import com.fatec.horario.dtos.PeriodicityResponse;
import org.springframework.stereotype.Component;

@Component
public class PeriodicityMapper {

    public Periodicity toEntity(PeriodicityRequest request) {
        if (request == null) {
            return null;
        }

        Periodicity periodicity = new Periodicity();
        periodicity.setDescription(request.getDescription());
        return periodicity;
    }

    public PeriodicityResponse toResponse(Periodicity entity) {
        if (entity == null) {
            return null;
        }

        PeriodicityResponse response = new PeriodicityResponse();
        response.setId(entity.getId());
        response.setDescription(entity.getDescription());
        return response;
    }
}
