package com.fatec.horario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftScheduleRepository extends JpaRepository<ShiftSchedule, Long> {
}