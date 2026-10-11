
package com.examenT2.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.entity.ProveedorThomburnePedro;
import com.examenT2.repository.ProveedorRepositoryThomburnePedro;
import com.examenT2.service.ProveedorServiceThomburnePedro;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImplThomburnePedro
        implements ProveedorServiceThomburnePedro {

    private final ProveedorRepositoryThomburnePedro proveedorRepository;

    @Override
    public List<ProveedorThomburnePedro> listarProveedores() {
        return proveedorRepository.findAll();
    }

}
