package com.fatec.horario.mappers;

import org.springframework.stereotype.Component;

import com.fatec.horario.dtos.TechAxisRequest;
import com.fatec.horario.dtos.TechAxisResponse;
import com.fatec.horario.entities.TechAxis;

@Component
public class TechAxisMapper {

    public TechAxis toEntity(TechAxisRequest request) {
        if (request == null) {
            return null;
        }

        TechAxis techAxis = new TechAxis();
        techAxis.setname(request.name());
        return techAxis;
    }

    public TechAxisResponse toResponse(TechAxis entity) {
        if (entity == null) {
            return null;
        }

        return new TechAxisResponse(
            entity.getId(),
            entity.getname()
        );
    }
}
