package com.fatec.horario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.horario.dtos.AcademicSemesterRequest;
import com.fatec.horario.dtos.AcademicSemesterResponse;
import com.fatec.horario.entities.AcademicSemester;
import com.fatec.horario.mappers.AcademicSemesterMapper;
import com.fatec.horario.repositories.AcademicSemesterRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AcademicSemesterService {

    @Autowired
    private AcademicSemesterRepository repository;

    public List<AcademicSemesterResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(AcademicSemesterMapper::toResponse)
                .toList();
    }

    public AcademicSemesterResponse getById(long id) {
        return repository.findById(id).map(AcademicSemesterMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Academic Semester not found."));
    }

    public AcademicSemesterResponse create(AcademicSemesterRequest request) {
        AcademicSemester academicSemester = AcademicSemesterMapper.toEntity(request);
        AcademicSemester savedAcademicSemester = repository.save(academicSemester);
        return AcademicSemesterMapper.toResponse(savedAcademicSemester);
    }

    public AcademicSemesterResponse update(AcademicSemesterRequest request, long id) {
        AcademicSemester aux = repository.getReferenceById(id);
        aux.setAcademicYear(request.academicYear());
        aux.setStatus(request.status());

        repository.save(aux);

        return AcademicSemesterMapper.toResponse(aux);
    }

    public void deleteAcademicSemesterById(long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new EntityNotFoundException("The academic semester does not exist.");

    }

}
