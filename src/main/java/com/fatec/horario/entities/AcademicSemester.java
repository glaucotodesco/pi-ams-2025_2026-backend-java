package com.fatec.horario.entities;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_ACADEMIC_SEMESTER")
public class AcademicSemester implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcademicSemester;

    @NotNull(message = "Academic Year is required")
    @Column(nullable = false)
    private Integer academicYear;

    @NotBlank(message = "Status is required")
    @Column(nullable = false, length = 20)
    private String status;

    public AcademicSemester() {}

    public AcademicSemester(Long idAcademicSemester, Integer academicYear, String status) {
        this.idAcademicSemester = idAcademicSemester;
        this.academicYear = academicYear;
        this.status = status;
    }

    public Long getIdAcademicSemester() {
        return idAcademicSemester;
    }

    public void setIdAcademicSemester(Long idAcademicSemester) {
        this.idAcademicSemester = idAcademicSemester;
    }

    public Integer getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return (idAcademicSemester == null) ? 0 : idAcademicSemester.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        AcademicSemester other = (AcademicSemester) obj;
        return idAcademicSemester != null && idAcademicSemester.equals(other.idAcademicSemester);
    }
}