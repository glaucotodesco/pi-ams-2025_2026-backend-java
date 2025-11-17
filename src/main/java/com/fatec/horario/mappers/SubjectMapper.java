package com.fatec.horario.mappers;

import com.fatec.horario.entities.Subject;
import com.fatec.horario.dtos.SubjectRequest;
import com.fatec.horario.dtos.SubjectResponse;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {

    public Subject toEntity(SubjectRequest request) {
        if (request == null) {
            return null;
        }
        Subject subject = new Subject();
        subject.setName(request.name());
        subject.setAcronym(request.acronym());
        subject.setPracticalLessonCount(request.practicalLessonCount());
        
        return subject;
    }

    public SubjectResponse toResponse(Subject subject) {
        if (subject == null) {
            return null;
        }
        return new SubjectResponse(
            subject.getId(),
            subject.getName(),
            subject.getAcronym(),
            subject.getPracticalLessonCount()
        );
    }
}