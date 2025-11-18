package com.fatec.horario.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record LessonRequest(
    
    @NotNull(message = "studentCount is required")
    @PositiveOrZero(message = "studentCount must be zero or positive")
    Integer studentCount

) {}
