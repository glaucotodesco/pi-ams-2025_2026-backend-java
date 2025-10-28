package com.fatec.horario.dtos;

public record CourseResponse(
    Long id,
    String name,
    String monality,
    String technologicalAxis,
    int numberOfComponents

) {}
