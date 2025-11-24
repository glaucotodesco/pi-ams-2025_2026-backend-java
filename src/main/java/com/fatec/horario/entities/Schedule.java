package com.fatec.horario.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer lessonNumber;

    @Column(nullable = false, length = 20)
    private Integer weekday;

    public Schedule() {}

    public Schedule(Long id, Integer lessonNumber, Integer weekday) {
        this.id = id;
        this.lessonNumber = lessonNumber;
        this.weekday = weekday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNuumber(Integer lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Schedule other = (Schedule) obj;
        return id != null && id.equals(other.id);
    }
}
