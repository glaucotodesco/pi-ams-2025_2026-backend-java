package com.fatec.horario.dtos;


public record ClassroomResponse(

    Long id,
    String name,
    String type,
    String location,
    Integer capacity,
    Boolean hasService,
    String items,
    String specifications

) {}
