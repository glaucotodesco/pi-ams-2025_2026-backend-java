package com.fatec.horario.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.horario.dtos.CourseRequest;
import com.fatec.horario.dtos.CourseResponse;
import com.fatec.horario.entities.Course;
import com.fatec.horario.mappers.CourseMapper;
import com.fatec.horario.repositories.CourseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public List<CourseResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(CourseMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CourseResponse getById(Long id) {
        Course course = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + id));

        return CourseMapper.toResponse(course);
    }

    public CourseResponse create(CourseRequest dto) {
        Course course = CourseMapper.toEntity(dto);
        Course saved = repository.save(course);
        return CourseMapper.toResponse(saved);
    }

    public CourseResponse update(Long id, CourseRequest dto) {
        Course course = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + id));

        course.setName(dto.name());
        course.setDescription(dto.description());

        Course updated = repository.save(course);
        return CourseMapper.toResponse(updated);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Course not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
