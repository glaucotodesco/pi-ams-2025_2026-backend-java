package com.fatec.horario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fatec.horario.dtos.AcademicSemesterRequest;
import com.fatec.horario.dtos.AcademicSemesterResponse;
import com.fatec.horario.entities.AcademicSemester;
import com.fatec.horario.mappers.AcademicSemesterMapper;
import com.fatec.horario.repositories.AcademicSemesterRepository;

import jakarta.persistence.EntityNotFoundException;

public class AcademicSemesterService {

    @Autowired
    private AcademicSemesterRepository repository;

    public List< AcademicSemesterResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(AcademicSemesterMapper::toDTO)
                .toList();
    }

        public AcademicSemesterResponse getById(long id) {
        return repository.findById(id).map(AcademicSemesterMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Academic Semester not found."));
    }
    
        public AcademicSemesterResponse saveAcademicSemester(AcademicSemesterRequest request) {
        AcademicSemester AcademicSemester = AcademicSemesterMapper.toEntity(request);
        AcademicSemester savedAcademicSemester = repository.save(AcademicSemester);
        return AcademicSemesterMapper.toDTO(savedAcademicSemester);
    }

        public AcademicSemesterResponse updateAcademicSemester(AcademicSemesterRequest request, long id) {
        AcademicSemester aux = repository.getReferenceById(id);
        aux.setAcademicYear(request.academicYear());
        aux.setStatus(request.status());

        repository.save(aux);

        return AcademicSemesterMapper.toDTO(aux);
    }

        public void deleteAcademicSemesterById(long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new EntityNotFoundException("The academic semester does not exist.");

    }

}
