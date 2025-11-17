package com.fatec.horario.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long Id;
    private String name;
    private String physicalResources;
    private String softwareResources;
    private Integer capacity;

    public Classroom(Long id, String name, String physicalResources, String softwareResources, Integer capacity) {
        Id = id;
        this.name = name;
        this.physicalResources = physicalResources;
        this.softwareResources = softwareResources;
        this.capacity = capacity;
    }

    public Classroom() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhysicalResources() {
        return physicalResources;
    }

    public void setPhysicalResources(String physicalResources) {
        this.physicalResources = physicalResources;
    }

    public String getSoftwareResources() {
        return softwareResources;
    }

    public void setSoftwareResources(String softwareResources) {
        this.softwareResources = softwareResources;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Id == null) ? 0 : Id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Classroom other = (Classroom) obj;
        if (Id == null) {
            if (other.Id != null)
                return false;
        } else if (!Id.equals(other.Id))
            return false;
        return true;
    }
    
}
