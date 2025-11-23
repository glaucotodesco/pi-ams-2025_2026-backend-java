package com.fatec.horario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.horario.dtos.ClassroomRequest;
import com.fatec.horario.dtos.ClassroomResponse;
import com.fatec.horario.entities.Classroom;
import com.fatec.horario.mappers.ClassroomMapper;
import com.fatec.horario.repositories.ClassroomRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository repository;

    public List<ClassroomResponse> getClassrooms() {
        return repository.findAll()
                .stream()
                .map(ClassroomMapper::toResponse)
                .toList();
    }

    public ClassroomResponse getClassroomById(long id) {
        return repository.findById(id)
                .map(ClassroomMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Classroom not not found."));
    }

    public ClassroomResponse saveClassroom(ClassroomRequest request) {
        Classroom classroom = ClassroomMapper.toEntity(request);
        classroom = repository.save(classroom);
        return ClassroomMapper.toResponse(classroom);
    }

    public void updateClassroom(ClassroomRequest request, long id) {
        Classroom classroom = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Classroom not found."));

        classroom.setName(request.name());
        classroom.setLocation(request.location());
        classroom.setPhysicalResources(request.physicalResources());
        classroom.setSoftwareResources(request.softwareResources());
        classroom.setCapacity(request.capacity());

        repository.save(classroom);
    }

    public void deleteClassroomById(long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new EntityNotFoundException("The classroom not found.");
    }

}
