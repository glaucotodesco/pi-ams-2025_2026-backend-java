package com.fatec.horario.services;

import com.fatec.horario.dtos.SubjectRequest;
import com.fatec.horario.dtos.SubjectResponse;
import com.fatec.horario.entities.Subject;
import com.fatec.horario.mappers.SubjectMapper;
import com.fatec.horario.repositories.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<SubjectResponse> getAll() {
        return subjectRepository.findAll()
                .stream()
                .map(SubjectMapper::toResponse)
                .toList();
    }

    public SubjectResponse getById(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));

        return SubjectMapper.toResponse(subject);
    }

    public SubjectResponse create(SubjectRequest request) {
        Subject subject = SubjectMapper.toEntity(request);
        subject = subjectRepository.save(subject);
        return SubjectMapper.toResponse(subject);
    }

    public SubjectResponse update(Long id, SubjectRequest request) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));

        subject.setName(request.name());
        subject.setAcronym(request.acronym());
        subject.setPracticalLessonCount(request.practicalLessonCount());

        subject = subjectRepository.save(subject);
        return SubjectMapper.toResponse(subject);
    }

    public void delete(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new RuntimeException("Subject not found with id: " + id);
        }

        subjectRepository.deleteById(id);
    }
}