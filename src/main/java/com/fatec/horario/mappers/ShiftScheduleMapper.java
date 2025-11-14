package com.fatec.horario.mappers;

import com.fatec.horario.entities.ShiftSchedule;
import com.fatec.horario.dtos.ShiftScheduleRequest;
import com.fatec.horario.dtos.ShiftScheduleResponse;
import org.springframework.stereotype.Component;

@Component
public class ShiftScheduleMapper {

    public ShiftSchedule toEntity(ShiftScheduleRequest request) {
        if (request == null) {
            return null;
        }

        ShiftSchedule entity = new ShiftSchedule();
        entity.setShiftDescription(request.getShiftDescription());
        entity.setStartTime(request.getStartTime());
        entity.setLessonCount(request.getLessonCount());
        entity.setLessonDuration(request.getLessonDuration());

        return entity;
    }

    public ShiftScheduleResponse toResponse(ShiftSchedule entity) {
        if (entity == null) {
            return null;
        }

        ShiftScheduleResponse response = new ShiftScheduleResponse();
        response.setId(entity.getId());
        response.setShiftDescription(entity.getShiftDescription());
        response.setStartTime(entity.getStartTime());
        response.setLessonCount(entity.getLessonCount());
        response.setLessonDuration(entity.getLessonDuration());

        return response;
    }
}
