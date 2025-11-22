package com.fatec.horario.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ScheduleRequest(

    @NotNull(message = "Lesson Number is required")
    @PositiveOrZero(message = "Lesson Number must be positive")
    Integer lessonNumber,

    @NotNull(message = "Weekday is required")
    @PositiveOrZero(message = "Weekday must be positive")
    Integer weekday
) {}
