package com.fatec.horario.mappers;

import com.fatec.horario.dtos.ClassroomRequest;
import com.fatec.horario.dtos.ClassroomResponse;
import com.fatec.horario.entities.Classroom;

public class ClassroomMapper {
    
    public static Classroom toEntity(ClassroomRequest request){
        Classroom Classroom = new Classroom();

        Classroom.setName(request.name());
        Classroom.setPhysicalResources(request.physicalResources());
        Classroom.setSoftwareResources(request.softwareResources());
        Classroom.setCapacity(request.capacity());

        return Classroom;
    }

    public static ClassroomResponse toResponse(Classroom Classroom) {
       return new ClassroomResponse(

       Classroom.getId(),
       Classroom.getName(),
       Classroom.getPhysicalResources(),
       Classroom.getSoftwareResources(),
       Classroom.getCapacity()

       );

    }

}
