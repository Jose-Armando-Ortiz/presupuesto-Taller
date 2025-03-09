package com.taller.presupuesto.presupuesto.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.taller.presupuesto.presupuesto.models.Vehiculos;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VehiculoRepository extends ReactiveCrudRepository<Vehiculos, Long> {
    @SuppressWarnings("null")
    Mono<Vehiculos> findById(Long id);
    @SuppressWarnings("null")
    Flux<Vehiculos> findAll();
}
