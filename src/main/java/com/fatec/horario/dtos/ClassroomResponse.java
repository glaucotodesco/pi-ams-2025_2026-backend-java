package com.fatec.horario.dtos;

public record ClassroomResponse(

  Long id,
  String name,
  String physicalResources,
  String softwareResources,
  Integer capacity

) {

    
}
