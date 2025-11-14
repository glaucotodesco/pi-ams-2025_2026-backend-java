package com.fatec.horario.dtos;

public class ShiftScheduleResponse {

    private Long id;
    private String shiftDescription;
    private Integer startTime;
    private Integer lessonCount;
    private Integer lessonDuration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
