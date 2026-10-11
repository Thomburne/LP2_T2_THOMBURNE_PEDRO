
package com.examenT2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenT2.entity.OrdenCompraThomburnePedro;

@Repository
public interface OrdenCompraRepositoryThomburnePedro
        extends JpaRepository<OrdenCompraThomburnePedro, Integer> {

    List<OrdenCompraThomburnePedro> findAllByOrderByNroOrdenDesc();

}
