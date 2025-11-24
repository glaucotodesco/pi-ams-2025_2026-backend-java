package com.fatec.horario.dtos;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class UserAvailabilityRequest {
    private Long userId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;
}
