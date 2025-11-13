package com.fatec.horario.dtos;

public record UserAvailabilityResponse(

    Long id,
    int weekday,
    int lessonNumber

) {
    
}
