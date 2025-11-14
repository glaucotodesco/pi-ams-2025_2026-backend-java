package com.fatec.horario.dtos;

import jakarta.validation.constraints.*;

public class ShiftScheduleRequest {

    @NotBlank
    private String shiftDescription;

    @NotNull
    @Min(0)
    @Max(23)
    private Integer startTime;

    @NotNull
    @Positive
    private Integer lessonCount;

    @NotNull
    @Positive
    private Integer lessonDuration;

    public String getShiftDescription() {
        return shiftDescription;
    }

    public void setShiftDescription(String shiftDescription) {
        this.shiftDescription = shiftDescription;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getLessonCount() {
        return lessonCount;
    }

    public void setLessonCount(Integer lessonCount) {
        this.lessonCount = lessonCount;
    }

    public Integer getLessonDuration() {
        return lessonDuration;
    }

    public void setLessonDuration(Integer lessonDuration) {
        this.lessonDuration = lessonDuration;
    }
}

