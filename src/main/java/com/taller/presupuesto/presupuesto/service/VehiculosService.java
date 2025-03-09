package com.taller.presupuesto.presupuesto.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.taller.presupuesto.presupuesto.models.Vehiculos;

public interface VehiculosService {
    Flux<Vehiculos> listarVehiculos();
    Mono<Vehiculos> buscarPorId(Long id);
    Mono<Vehiculos> guardar(Vehiculos vehiculo);
    Mono<Void> eliminar(Long id);
}