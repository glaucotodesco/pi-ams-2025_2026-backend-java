package com.fatec.horario.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ClassGroupRequest(

 @NotBlank
 @Min(value = 1, message = "is required, This field must be filled in.")
 Integer studentCount

) {

    
}
