package com.fatec.horario.mappers;

import org.mapstruct.*;
import com.fatec.horario.dtos.UserAvailabilityRequest;
import com.fatec.horario.dtos.UserAvailabilityResponse;
import com.fatec.horario.entities.UserAvailability;

@Mapper(componentModel = "spring")
public interface UserAvailabilityMapper {

    @Mapping(source = "userId", target = "user.id")
    UserAvailability toEntity(UserAvailabilityRequest dto);

    @Mapping(source = "user.id", target = "userId")
    UserAvailabilityResponse toResponse(UserAvailability entity);

    @Mapping(source = "userId", target = "user.id")
    void updateEntityFromDto(UserAvailabilityRequest dto, @MappingTarget UserAvailability entity);
}
