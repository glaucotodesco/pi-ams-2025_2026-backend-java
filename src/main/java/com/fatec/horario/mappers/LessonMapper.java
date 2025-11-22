package com.fatec.horario.mappers;

import com.fatec.horario.dtos.LessonRequest;
import com.fatec.horario.dtos.LessonResponse;
import com.fatec.horario.entities.Lesson;

public class LessonMapper {

    public static Lesson toEntity(LessonRequest request) {
        Lesson lesson = new Lesson();
        lesson.setStudentCount(request.studentCount());
        return lesson;
    }

    public static LessonResponse toResponse(Lesson lesson) {
        return new LessonResponse(
            lesson.getId(),
            lesson.getStudentCount()
        );
    }
}
