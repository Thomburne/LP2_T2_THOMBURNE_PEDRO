
package com.examenT2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.entity.OrdenCompraThomburnePedro;
import com.examenT2.service.OrdenCompraServiceThomburnePedro;
import com.examenT2.service.ProveedorServiceThomburnePedro;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/orden")
@RequiredArgsConstructor
public class OrdenCompraControllerThomburnePedro {

    private final OrdenCompraServiceThomburnePedro ordenService;
    private final ProveedorServiceThomburnePedro proveedorService;

    @GetMapping("/listado")
    public String listado(Model model) {

        model.addAttribute(
            "ordenes",
            ordenService.listarOrdenes()
        );

        return "listadoThomburnePedro";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute(
            "orden",
            new OrdenCompraThomburnePedro()
        );

        model.addAttribute(
            "proveedores",
            proveedorService.listarProveedores()
        );

        return "nuevoThomburnePedro";
    }

    @PostMapping("/registrar")
    public String registrar(
            @ModelAttribute("orden")
            OrdenCompraThomburnePedro orden,
            RedirectAttributes redirect) {

        orden.setNroOrden(null);

        OrdenCompraThomburnePedro guardada =
                ordenService.guardarOrden(orden);

        redirect.addFlashAttribute(
            "mensaje",
            "Orden de compra Nro. "
            + guardada.getNroOrden()
            + " registrada."
        );

        return "redirect:/orden/listado";
    }

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Integer id,
            Model model) {

        OrdenCompraThomburnePedro orden =
                ordenService.buscarPorId(id)
                    .orElseThrow(() ->
                        new IllegalArgumentException(
                            "Orden no encontrada: " + id
                        )
                    );

        model.addAttribute("orden", orden);

        model.addAttribute(
            "proveedores",
            proveedorService.listarProveedores()
        );

        return "edicionThomburnePedro";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute("orden")
            OrdenCompraThomburnePedro orden,
            RedirectAttributes redirect) {

        Integer numero = orden.getNroOrden();

        if (numero == null ||
                ordenService.buscarPorId(numero).isEmpty()) {
            throw new IllegalArgumentException(
                "Orden no encontrada: " + numero
            );
        }

        ordenService.guardarOrden(orden);

        redirect.addFlashAttribute(
            "mensaje",
            "Orden de compra Nro. "
            + numero
            + " actualizada."
        );

        return "redirect:/orden/listado";
    }
}
