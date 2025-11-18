package com.fatec.horario.mappers;

import com.fatec.horario.dtos.LessonRequest;
import com.fatec.horario.dtos.LessonResponse;
import com.fatec.horario.entities.Lesson;

public class LessonMapper {

    // Request -> Entity
    public static Lesson toEntity(LessonRequest request) {
        Lesson lesson = new Lesson();
        lesson.setStudentCount(request.studentCount());
        return lesson;
    }

    // Entity -> Response
    public static LessonResponse toResponse(Lesson lesson) {
        return toResponse(lesson, true);
    }

    // Version with includeRelations for future expansion
    public static LessonResponse toResponse(Lesson lesson, boolean includeRelations) {
        if (lesson == null) return null;

        return new LessonResponse(
            lesson.getId(),
            lesson.getStudentCount()
        );
    }
}
