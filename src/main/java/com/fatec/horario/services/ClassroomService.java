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
                .orElseThrow(() -> new EntityNotFoundException("Classroom not registered."));
    }

    public ClassroomResponse saveClassroom(ClassroomRequest request) {
        Classroom Classroom = ClassroomMapper.toEntity(request);
        Classroom savedClassroom = repository.save(Classroom);
        return ClassroomMapper.toResponse(savedClassroom);
    }

    public void updateClassroom(ClassroomRequest request, long id) {
        Classroom Classroom = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Classroom not found."));

        Classroom.setName(request.name());
        Classroom.setPhysicalResources(request.physicalResources());
        Classroom.setSoftwareResources(request.softwareResources());
        Classroom.setCapacity(request.capacity());

        repository.save(Classroom);
    }

     public void deleteClassroomById(long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new EntityNotFoundException("The classroom doesn't exist.");
    }

}
