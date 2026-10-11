
package com.examenT2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examenT2.entity.OrdenCompraThomburnePedro;
import com.examenT2.repository.OrdenCompraRepositoryThomburnePedro;
import com.examenT2.service.OrdenCompraServiceThomburnePedro;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraServiceImplThomburnePedro
        implements OrdenCompraServiceThomburnePedro {

    private final OrdenCompraRepositoryThomburnePedro ordenRepository;

    @Override
    public List<OrdenCompraThomburnePedro> listarOrdenes() {
        return ordenRepository.findAllByOrderByNroOrdenDesc();
    }

    @Override
    public Optional<OrdenCompraThomburnePedro> buscarPorId(Integer id) {
        return ordenRepository.findById(id);
    }

    @Override
    public OrdenCompraThomburnePedro guardarOrden(
            OrdenCompraThomburnePedro orden) {
        return ordenRepository.save(orden);
    }
}
