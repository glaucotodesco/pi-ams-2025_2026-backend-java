package com.fatec.horario.dtos;

public record ScheduleResponse (
    Long id,
    Integer lessonNumber,
    Integer weekday
){}
