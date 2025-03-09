package com.taller.presupuesto.presupuesto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(name = "vehiculos") // Se usa @Table de R2DBC en lugar de @Entity
public class Vehiculos {

    @Id
    @Column("id")
    private Long id;

    @Column("vehiculo_modelo")
    private String vehiculoModelo;

    @Column("total_chaperia")
    private Double totalChaperia;

    @Column("total_pintura")
    private Double totalPintura;

    @Column("total")
    private Double total;
}
