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
        entity.setShiftDescription(request.shiftDescription());
        entity.setStartTime(request.startTime());
        entity.setLessonCount(request.lessonCount());
        entity.setLessonDuration(request.lessonDuration());

        return entity;
    }

    public ShiftScheduleResponse toResponse(ShiftSchedule entity) {
        if (entity == null) {
            return null;
        }

        ShiftScheduleResponse response = new ShiftScheduleResponse(
                entity.getId(),
                entity.getShiftDescription(),
                entity.getStartTime(),
                entity.getLessonCount(),
                entity.getLessonDuration());

        return response;
    }
}
