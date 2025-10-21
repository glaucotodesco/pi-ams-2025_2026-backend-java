package com.fatec.horario.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "curriculum")
public class Curriculum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Abreviação é obrigatória")
    @Size(max = 8, message = "Abreviação deve ter no máximo 8 caracteres")
    @Column(nullable = false, length = 8)
    private String abbreviation;

    @NotNull(message = "Curso é obrigatório")
    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @NotBlank(message = "Área tecnológica é obrigatória")
    @Size(max = 60, message = "Área tecnológica deve ter no máximo 60 caracteres")
    @Column(nullable = false, length = 60)
    private String technologyArea;

    @NotNull(message = "Carga horária teórica é obrigatória")
    @Column(nullable = false)
    private Integer theoretical;

    @NotNull(message = "Carga horária prática é obrigatória")
    @Column(nullable = false)
    private Integer practical;

    @NotNull(message = "Quantidade de aulas é obrigatória")
    @Column(nullable = false)
    private Integer quantityClass;

    @NotBlank(message = "Modalidade é obrigatória")
    @Size(max = 40, message = "Modalidade deve ter no máximo 40 caracteres")
    @Column(nullable = false, length = 40)
    private String modality;

    public Curriculum() {
    }

    public Curriculum(Long id, String name, String abbreviation, Long courseId, String technologyArea,
                      Integer theoretical, Integer practical, Integer quantityClass, String modality) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.courseId = courseId;
        this.technologyArea = technologyArea;
        this.theoretical = theoretical;
        this.practical = practical;
        this.quantityClass = quantityClass;
        this.modality = modality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTechnologyArea() {
        return technologyArea;
    }

    public void setTechnologyArea(String technologyArea) {
        this.technologyArea = technologyArea;
    }

    public Integer getTheoretical() {
        return theoretical;
    }

    public void setTheoretical(Integer theoretical) {
        this.theoretical = theoretical;
    }

    public Integer getPractical() {
        return practical;
    }

    public void setPractical(Integer practical) {
        this.practical = practical;
    }

    public Integer getQuantityClass() {
        return quantityClass;
    }

    public void setQuantityClass(Integer quantityClass) {
        this.quantityClass = quantityClass;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }
}

