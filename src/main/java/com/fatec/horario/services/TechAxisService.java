package com.fatec.horario.services;

import java.util.List;

import com.fatec.horario.dtos.TechAxisRequest;
import com.fatec.horario.dtos.TechAxisResponse;

public interface TechAxisService {

    TechAxisResponse getById(Long id);

    List<TechAxisResponse> getAll();

    TechAxisResponse create(TechAxisRequest dto);

    TechAxisResponse update(Long id, TechAxisRequest dto);

    void delete(Long id);
}
