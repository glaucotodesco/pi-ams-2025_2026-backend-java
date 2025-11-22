package com.fatec.horario.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ClassGroupRequest(

    @NotNull(message = "Student Count is required") 
    @PositiveOrZero(message = "Student Count must positive") 
    Integer studentCount
) {

}
