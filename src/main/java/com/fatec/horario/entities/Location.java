package com.fatec.horario.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Floor cannot be blank")
    @Size(max = 20, message = "Floor can have at most 20 characters")
    private String floor;

    @NotBlank(message = "Sector cannot be blank")
    @Size(max = 50, message = "Sector can have at most 50 characters")
    private String sector;

    // TODO: Future relation with Classroom or Building

    // Constructors
    public Location() {
    }

    public Location(Long id, String floor, String sector) {
        this.id = id;
        this.floor = floor;
        this.sector = sector;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
