package com.fatec.horario.mappers;

import com.fatec.horario.entities.Subject;
import com.fatec.horario.dtos.SubjectRequest;
import com.fatec.horario.dtos.SubjectResponse;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {

    public static Subject toEntity(SubjectRequest request) {

        Subject subject = new Subject();
        subject.setName(request.name());
        subject.setAcronym(request.acronym());
        subject.setPracticalLessonCount(request.practicalLessonCount());
        subject.setSemesterNumber(request.semesterNumber());

        return subject;
    }

    public static SubjectResponse toResponse(Subject subject) {
        return new SubjectResponse(
                subject.getId(),
                subject.getName(),
                subject.getAcronym(),
                subject.getPracticalLessonCount(),
                subject.getSemesterNumber());
    }
}