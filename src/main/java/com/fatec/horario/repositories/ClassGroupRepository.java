package com.fatec.horario.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.horario.entities.ClassGroup;

@Repository
public interface ClassGroupRepository extends JpaRepository<ClassGroup, Long> {

     List<ClassGroup> findByClassGroupId(Long ClassGroupId);
}