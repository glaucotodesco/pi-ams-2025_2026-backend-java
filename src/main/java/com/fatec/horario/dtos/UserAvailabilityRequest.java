package com.fatec.horario.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UserAvailabilityRequest(

    @NotBlank @Min(value = 1, message = "It cannot be less than one.")
    @Max(value = 7, message = "There can't be more than seven.")
    int weekday,

    @NotBlank 
    @Positive(message = "it has to be positive.")
    int lessonNumber

) {

}
