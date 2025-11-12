package com.fatec.horario.mappers;

import com.fatec.horario.dtos.ClassroomRequest;
import com.fatec.horario.dtos.ClassroomResponse;
import com.fatec.horario.entities.Classroom;

public class ClassroomMapper {
    
     public static Classroom toEntity(ClassroomRequest request){
        Classroom classroom = new Classroom();

        classroom.setName(request.name());
        classroom.setType(request.type());
        classroom.setLocation(request.location());
        classroom.setCapacity(request.capacity());
        classroom.setHasService(request.hasService());
        classroom.setItems(request.items());
        classroom.setSpecifications(request.specifications());

        return classroom;
     }

    public static ClassroomResponse toResponse(Classroom classroom) {
       return new ClassroomResponse(

       classroom.getId(),
       classroom.getName(),
       classroom.getType(),
       classroom.getLocation(),
       classroom.getCapacity(),
       classroom.getHasService(),
       classroom.getItems(),
       classroom.getSpecifications()

       );
    }
}
