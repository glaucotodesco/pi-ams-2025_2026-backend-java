package com.fatec.horario.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LocationRequest {

    @NotBlank(message = "Floor cannot be blank")
    @Size(max = 20, message = "Floor can have at most 20 characters")
    private String floor;

    @NotBlank(message = "Sector cannot be blank")
    @Size(max = 50, message = "Sector can have at most 50 characters")
    private String sector;

    // Getters and Setters
    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
