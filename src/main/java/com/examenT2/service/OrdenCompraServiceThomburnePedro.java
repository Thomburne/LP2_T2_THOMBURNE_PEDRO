
package com.examenT2.service;

import java.util.List;
import java.util.Optional;

import com.examenT2.entity.OrdenCompraThomburnePedro;

public interface OrdenCompraServiceThomburnePedro {

    List<OrdenCompraThomburnePedro> listarOrdenes();

    Optional<OrdenCompraThomburnePedro> buscarPorId(Integer id);

    OrdenCompraThomburnePedro guardarOrden(
            OrdenCompraThomburnePedro orden);

}
