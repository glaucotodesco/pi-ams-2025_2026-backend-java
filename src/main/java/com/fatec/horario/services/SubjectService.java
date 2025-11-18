package com.fatec.horario.services;

import com.fatec.horario.dtos.SubjectRequest;
import com.fatec.horario.dtos.SubjectResponse;
import com.fatec.horario.entities.Subject;
import com.fatec.horario.mappers.SubjectMapper;
import com.fatec.horario.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public SubjectService(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    public List<SubjectResponse> getAll() {
        return subjectRepository.findAll()
                .stream()
                .map(subjectMapper::toResponse)
                .collect(Collectors.toList());
    }

    public SubjectResponse getById(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));

        return subjectMapper.toResponse(subject);
    }

    public SubjectResponse create(SubjectRequest dto) {
        Subject subject = subjectMapper.toEntity(dto);
        Subject saved = subjectRepository.save(subject);
        return subjectMapper.toResponse(saved);
    }

    public SubjectResponse update(Long id, SubjectRequest dto) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));

        subject.setName(dto.name());
        subject.setAcronym(dto.acronym());
        subject.setPracticalLessonCount(dto.practicalLessonCount());

        Subject updated = subjectRepository.save(subject);
        return subjectMapper.toResponse(updated);
    }

    public void delete(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new RuntimeException("Subject not found with id: " + id);
        }

        subjectRepository.deleteById(id);
    }
}