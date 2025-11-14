package com.fatec.horario.dtos;

public record AcademicSemesterResponse (
    Long idAcademicSemester,
    Integer academicYear,
    String status
){}
