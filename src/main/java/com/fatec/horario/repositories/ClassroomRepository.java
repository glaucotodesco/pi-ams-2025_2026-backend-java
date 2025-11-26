package com.fatec.horario.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fatec.horario.entities.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
        List<Classroom> findByIsTemplate(boolean isTemplate);
        List<Classroom> findByIsPractical(boolean isPractical);
}