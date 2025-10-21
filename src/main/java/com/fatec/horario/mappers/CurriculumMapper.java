package com.fatec.horario.mappers;

import com.fatec.horario.entities.Curriculum;
import com.fatec.horario.dtos.CurriculumRequest;
import com.fatec.horario.dtos.CurriculumResponse;
import org.springframework.stereotype.Component;

@Component
public class CurriculumMapper {

    public Curriculum toEntity(CurriculumRequest request) {
        if (request == null) {
            return null;
        }
        Curriculum curriculum = new Curriculum();
        curriculum.setName(request.getName());
        curriculum.setAbbreviation(request.getAbbreviation());
        curriculum.setCourseId(request.getCourseId());
        curriculum.setTechnologyArea(request.getTechnologyArea());
        curriculum.setTheoretical(request.getTheoretical());
        curriculum.setPractical(request.getPractical());
        curriculum.setQuantityClass(request.getQuantityClass());
        curriculum.setModality(request.getModality());
        return curriculum;
    }

    public CurriculumResponse toResponse(Curriculum curriculum) {
        if (curriculum == null) {
            return null;
        }
        return new CurriculumResponse(
            curriculum.getId(),
            curriculum.getName(),
            curriculum.getAbbreviation(),
            curriculum.getCourseId(),
            curriculum.getTechnologyArea(),
            curriculum.getTheoretical(),
            curriculum.getPractical(),
            curriculum.getQuantityClass(),
            curriculum.getModality()
        );
    }
}