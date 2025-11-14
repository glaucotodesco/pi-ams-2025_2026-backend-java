package com.fatec.horario.mappers;

import com.fatec.horario.dtos.ScheduleRequest;
import com.fatec.horario.dtos.ScheduleResponse;
import com.fatec.horario.entities.Schedule;

public class ScheduleMapper {

public static Schedule toEntity(ScheduleRequest request) {
    Schedule schedule = new Schedule();
    schedule.setLessonNuumber(request.lessonNumber());
    schedule.setWeekday(request.weekday());
    return schedule;
    }

    public static ScheduleResponse toDTO(Schedule schedule) {
        return new ScheduleResponse(
            schedule.getId(),
            schedule.getLessonNumber(),
            schedule.getWeekday()
        );
    }

}
