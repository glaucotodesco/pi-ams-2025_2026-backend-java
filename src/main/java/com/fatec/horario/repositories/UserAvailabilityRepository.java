package com.fatec.horario.repositories;

import com.fatec.horario.entities.UserAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAvailabilityRepository extends JpaRepository<UserAvailability, Long> {
}
