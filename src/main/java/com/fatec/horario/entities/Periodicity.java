package com.fatec.horario.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "periodicity")
public class Periodicity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodicity")
    private Long idPeriodicity;

    @NotBlank
    @Size(max = 255)
    @Column(name = "description", nullable = false, length = 255)
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
