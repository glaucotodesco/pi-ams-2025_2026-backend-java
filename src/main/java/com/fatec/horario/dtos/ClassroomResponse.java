package com.fatec.horario.dtos;

public record ClassroomResponse(

  Long Id,
  String name,
  String physicalResources,
  String softwareResources,
  Integer capacity

) {

    
}
