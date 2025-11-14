package com.fatec.horario.mappers;

import com.fatec.horario.dtos.AcademicSemesterRequest;
import com.fatec.horario.dtos.AcademicSemesterResponse;
import com.fatec.horario.entities.AcademicSemester;

public class AcademicSemesterMapper {

    public static AcademicSemester toEntity(AcademicSemesterRequest request) {
    AcademicSemester academicSemester = new AcademicSemester();
    academicSemester.setIdAcademicSemester(request.idAcademicSemester());
    academicSemester.setAcademicYear(request.academicYear());
    academicSemester.setStatus(request.status());
    return academicSemester;
    }

    public static AcademicSemesterResponse toDTO(AcademicSemester academicSemester) {
        return new AcademicSemesterResponse(
            academicSemester.getIdAcademicSemester(),
            academicSemester.getAcademicYear(),
            academicSemester.getStatus()
        );
    }

}
