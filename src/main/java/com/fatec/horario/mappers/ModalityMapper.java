package com.fatec.horario.mappers;

import com.fatec.horario.dtos.ModalityRequest;
import com.fatec.horario.dtos.ModalityResponse;
import com.fatec.horario.entities.Modality;
import org.springframework.stereotype.Component;

@Component
public class ModalityMapper {

    public Modality toEntity(ModalityRequest request) {
        if (request == null) {
            return null;
        }
        Modality Modality = new Modality();
        Modality.setName(request.name());
        return Modality;
    }

    public ModalityResponse toResponse(Modality Modality) {
        if (Modality == null) {
            return null;
        }
        return new ModalityResponse(
            Modality.getId(),
            Modality.getName()
        );
    }
}