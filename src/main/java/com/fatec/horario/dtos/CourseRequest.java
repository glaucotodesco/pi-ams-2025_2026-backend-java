package com.fatec.horario.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CourseRequest(
    @NotBlank(message = "Name is required")
    @Size (min = 2, max = 255, message = "the name must be between 2 and 255 characters long")
    String name, 

    @NotBlank (message = "monality is required")
    @Size (min = 2, max = 255, message = "the monality must be between 2 and 255 characters long")
    String modality,

    @NotBlank (message = "technological axis is required")
    @Size (min = 2, max = 255, message = "the technological must be between 2 and 255 characters long")
    String technologicalAxis,

    @NotBlank (message = "numberOfComponents is required")
    @Min(value = 0, message = "minimum value is zero")
    int numberOfComponents

) {


    
}
