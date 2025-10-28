package com.fatec.horario.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CurriculumRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 100)
    private String name;

    @NotBlank(message = "Abbreviation is required")
    @Size(max = 20)
    private String abbreviation;

    @NotNull(message = "Course ID is required")
    private Long courseId;

    @NotBlank(message = "Technology area is required")
    @Size(max = 60)
    private String technologyArea;

    @NotNull(message = "Theoretical workload is required")
    private Integer theoretical;

    @NotNull(message = "Practical workload is required")
    private Integer practical;

    @NotNull(message = "Number of classes is required")
    private Integer quantityClass;

    @NotBlank(message = "Modality is required")
    @Size(max = 40)
    private String modality;

    public CurriculumRequest() {
    }

    public CurriculumRequest(String name, String abbreviation, Long courseId, String technologyArea,
                             Integer theoretical, Integer practical, Integer quantityClass, String modality) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.courseId = courseId;
        this.technologyArea = technologyArea;
        this.theoretical = theoretical;
        this.practical = practical;
        this.quantityClass = quantityClass;
        this.modality = modality;
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
