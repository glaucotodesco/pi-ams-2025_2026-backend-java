package com.fatec.horario.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "shift_schedule")
public class ShiftSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shift_schedule")
    private Long id;

    @NotBlank
    @Column(name = "shift_description", nullable = false, length = 255)
    private String shiftDescription;

    @NotNull
    @Min(0)
    @Max(23)
    @Column(name = "start_time", nullable = false)
    private Integer startTime;

    @NotNull
    @Positive
    @Column(name = "lesson_count", nullable = false)
    private Integer lessonCount;

    @NotNull
    @Positive
    @Column(name = "lesson_duration", nullable = false)
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
