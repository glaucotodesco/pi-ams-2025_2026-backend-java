package com.fatec.horario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.horario.dtos.UserRequest;
import com.fatec.horario.dtos.UserResponse;
import com.fatec.horario.entities.AccessLevel;
import com.fatec.horario.entities.User;
import com.fatec.horario.mappers.UserMapper;
import com.fatec.horario.repositories.AccessLevelRepository;
import com.fatec.horario.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccessLevelRepository accessLevelRepository;

    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return UserMapper.toResponse(user);
    }

    public UserResponse create(UserRequest request) {
        User user = UserMapper.toEntity(request);
        if (request.accessLevelId() != null) {
            AccessLevel accessLevel = accessLevelRepository.findById(request.accessLevelId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Acess Level not found with id: " + request.accessLevelId()));
            user.setAccessLevel(accessLevel);
        }

        user = userRepository.save(user);
        return UserMapper.toResponse(user);
    }

    public UserResponse update(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password());

        if (request.accessLevelId() != null) {
            AccessLevel accessLevel = accessLevelRepository.findById(request.accessLevelId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Acess Level not found with id: " + request.accessLevelId()));
            user.setAccessLevel(accessLevel);
        } else {
            user.setAccessLevel(null);
        }

        user = userRepository.save(user);
        return UserMapper.toResponse(user);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
