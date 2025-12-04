package com.fatec.horario.dtos;

public record ScheduleResponse (
    Long id,
    Integer lessonNumber,
    Integer weekday,
    Long shiftScheduleId,
    Long classroomId,
    Long academicSemesterId,
    Long subjectId,
    Long professorId
){}
