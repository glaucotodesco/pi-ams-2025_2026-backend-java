package com.fatec.horario.mappers;

import com.fatec.horario.dtos.ScheduleRequest;
import com.fatec.horario.dtos.ScheduleResponse;
import com.fatec.horario.entities.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {

    public Schedule toEntity(ScheduleRequest request) {
        if (request == null) {
            return null;
        }
        Schedule schedule = new Schedule();
        schedule.setLessonNuumber(request.lessonNumber());
        schedule.setWeekday(request.weekday());
        return schedule;
    }

    public ScheduleResponse toDTO(Schedule schedule) {
        if (schedule == null) {
            return null;
        }
        return new ScheduleResponse(
            schedule.getId(),
            schedule.getLessonNumber(),
            schedule.getWeekday()
        );
    }
}
