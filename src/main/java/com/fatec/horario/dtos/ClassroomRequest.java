package com.fatec.horario.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClassroomRequest(

   @NotBlank(message = "Name is required")
   @Size(min = 2, max = 255, message = "the name must be between 2 and 255 characters long")
   String name,

   @NotBlank(message = "Type is required")
   @Size (min = 2, max = 255, message = "the type must be between 2 and 255 characters long")
   String type,

   @NotBlank(message = "Location is required")
   @Size (min = 2, max = 255, message = "the location must be between 2 and 255 characters long")
   String location,

   @NotBlank(message = "capacity is required")
   Integer capacity,

   Boolean hasService,

   @NotBlank(message = "items is required")
   String items,

   @NotBlank(message = " Specifications is required")
   @Size( min = 0, max = 500, message = "Specifications can have a maximum of 500 characters")
   String specifications

) {}