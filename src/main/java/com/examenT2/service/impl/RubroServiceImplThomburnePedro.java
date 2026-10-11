
package com.examenT2.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.entity.RubroThomburnePedro;
import com.examenT2.repository.RubroRepositoryThomburnePedro;
import com.examenT2.service.RubroServiceThomburnePedro;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RubroServiceImplThomburnePedro
        implements RubroServiceThomburnePedro {

    private final RubroRepositoryThomburnePedro rubroRepository;

    @Override
    public List<RubroThomburnePedro> listarRubros() {
        return rubroRepository.findAll();
    }
}
