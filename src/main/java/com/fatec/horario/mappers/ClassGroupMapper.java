package com.fatec.horario.mappers;

import com.fatec.horario.dtos.ClassGroupRequest;
import com.fatec.horario.dtos.ClassGroupResponse;
import com.fatec.horario.entities.ClassGroup;

public class ClassGroupMapper {
    
    public static ClassGroup toEntity(ClassGroupRequest request){
        com.fatec.horario.entities.ClassGroup ClassGroup = new ClassGroup();

    ClassGroup.setStudentQuantity(request.studentQuantity());

        return ClassGroup;

    }

    public static ClassGroupResponse toResponse(com.fatec.horario.entities.ClassGroup ClassGroup) {
       return new ClassGroupResponse(

    ClassGroup.getId(),
    ClassGroup.getStudentQuantity()

       );

    }
}
