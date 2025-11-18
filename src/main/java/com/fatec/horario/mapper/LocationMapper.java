package com.fatec.horario.mapper;

import com.fatec.horario.entities.Location;
import com.fatec.horario.dtos.LocationRequest;
import com.fatec.horario.dtos.LocationResponse;

public class LocationMapper {

    public static Location toEntity(LocationRequest dto) {
        Location location = new Location();
        location.setFloor(dto.getFloor());
        location.setSector(dto.getSector());
        return location;
    }

    public static LocationResponse toResponse(Location entity) {
        return new LocationResponse(
                entity.getId(),
                entity.getFloor(),
                entity.getSector());
    }
}
