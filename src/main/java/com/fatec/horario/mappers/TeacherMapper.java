package com.fatec.horario.mappers;

import com.fatec.horario.entities.Teacher;
import com.fatec.horario.dtos.TeacherRequest;
import com.fatec.horario.dtos.TeacherResponse;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public Teacher toEntity(TeacherRequest request) {
        if (request == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setName(request.getName());
        teacher.setEmail(request.getEmail());
        teacher.setDepartment(request.getDepartment());
        return teacher;
    }

    public TeacherResponse toResponse(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        return new TeacherResponse(
            teacher.getId(),
            teacher.getName(),
            teacher.getEmail(),
            teacher.getDepartment()
        );
    }
}
