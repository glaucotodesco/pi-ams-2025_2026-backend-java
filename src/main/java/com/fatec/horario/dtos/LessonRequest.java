package com.fatec.horario.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record LessonRequest(
    
    @NotNull(message = "StudentCount is required")
    @PositiveOrZero(message = "StudentCount must be zero or positive")
    Integer studentCount

) {}
