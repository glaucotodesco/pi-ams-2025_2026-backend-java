package com.fatec.horario.mappers;

import com.fatec.horario.dtos.ScheduleRequest;
import com.fatec.horario.dtos.ScheduleResponse;
import com.fatec.horario.entities.Schedule;

public class ScheduleMapper {

    public static Schedule toEntity(ScheduleRequest request) {
        Schedule schedule = new Schedule();
        schedule.setLessonNumber(request.lessonNumber());
        schedule.setWeekday(request.weekday());
        return schedule;
    }

    public static ScheduleResponse toResponse(Schedule schedule) {
        return new ScheduleResponse(
            schedule.getId(),
            schedule.getLessonNumber(),
            schedule.getWeekday(),
            schedule.getShiftSchedule() != null ? schedule.getShiftSchedule().getId() : null,
            schedule.getClassroom() != null ? schedule.getClassroom().getId() : null,
            schedule.getAcademicSemester() != null ? schedule.getAcademicSemester().getId() : null,
            schedule.getSubject() != null ? schedule.getSubject().getId() : null,
            schedule.getProfessor() != null ? schedule.getProfessor().getId() : null
        );
    }
}
