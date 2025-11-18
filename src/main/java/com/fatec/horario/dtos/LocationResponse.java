package com.fatec.horario.dtos;

public class LocationResponse {

    private Long id;
    private String floor;
    private String sector;

    public LocationResponse(Long id, String floor, String sector) {
        this.id = id;
        this.floor = floor;
        this.sector = sector;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getFloor() {
        return floor;
    }

    public String getSector() {
        return sector;
    }
}
