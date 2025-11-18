package com.fatec.horario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fatec.horario.entities.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}