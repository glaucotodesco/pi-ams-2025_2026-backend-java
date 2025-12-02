package com.fatec.horario.dtos;

public record SubjectResponse(
    Long id,
    String name,
    String acronym, 
    Integer practicalLessonCount,
    Integer semesterNumber

    ) {
}
