
package com.examenT2.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_proveedor")
public class ProveedorThomburnePedro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "ruc", columnDefinition = "CHAR(11)", nullable = false)
    private String ruc;

    @Column(name = "razon_social", length = 50, nullable = false, unique = true)
    private String razonSocial;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;

    @Column(name = "pagina_web", length = 100)
    private String paginaWeb;

    @ManyToOne
    @JoinColumn(name = "id_rubro")
    private RubroThomburnePedro rubro;

}
