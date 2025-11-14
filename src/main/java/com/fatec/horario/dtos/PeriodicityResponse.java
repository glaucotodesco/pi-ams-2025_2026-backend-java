package com.fatec.horario.dtos;

public class PeriodicityResponse {

    private Long idPeriodicity;
    private String description;

    public Long getIdPeriodicity() {
        return idPeriodicity;
    }

    public void setIdPeriodicity(Long idPeriodicity) {
        this.idPeriodicity = idPeriodicity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
