package com.fatec.horario.dtos;

public class CurriculumResponse {

    private Long id;
    private String name;
    private String abbreviation;
    private Long courseId;
    private String technologyArea;
    private Integer theoretical;
    private Integer practical;
    private Integer quantityClass;
    private String modality;

    public CurriculumResponse() {
    }

    public CurriculumResponse(Long id, String name, String abbreviation, Long courseId, String technologyArea,
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