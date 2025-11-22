package com.fatec.horario.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record SubjectRequest(
        @NotBlank(message = "Name is required") 
        @Size(max = 100) 
        String name,
        @Size(max = 20) 
        String acronym,
        @PositiveOrZero(message = "Pratical Lesson Count must be positive")
        Integer practicalLessonCount
) {

}
