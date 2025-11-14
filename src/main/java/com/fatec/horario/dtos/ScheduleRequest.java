package com.fatec.horario.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ScheduleRequest(

    @NotNull(message = "Lesson Number is required")
    @Min(value = 1, message = "Lesson Number must be greater than or equal to 1")
    @Max(value = 6, message = "Lesson Number must be less than or equal to 6")
    Integer lessonNumber,

    @NotBlank(message = "Weekday is required")
    @Min(value = 1, message = "Weekday must be greater than or equal to 1")
    @Max(value = 7, message = "Weekday must be less than or equal to 7")
    Integer weekday

) {}
