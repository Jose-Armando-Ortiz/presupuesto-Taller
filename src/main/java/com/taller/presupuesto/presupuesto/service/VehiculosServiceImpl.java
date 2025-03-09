package com.taller.presupuesto.presupuesto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.taller.presupuesto.presupuesto.models.Vehiculos;
import com.taller.presupuesto.presupuesto.repository.VehiculoRepository;

@Service
public class VehiculosServiceImpl implements VehiculosService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Flux<Vehiculos> listarVehiculos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Mono<Vehiculos> buscarPorId(Long id) {
        return vehiculoRepository.findById(id);
    }

    @Override
    public Mono<Vehiculos> guardar(Vehiculos vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Mono<Void> eliminar(Long id) {
        return vehiculoRepository.deleteById(id);
    }
    public Mono<Vehiculos> SumaTotal(Vehiculos vehiculo) {
        vehiculo.setTotal(vehiculo.getTotalChaperia() + vehiculo.getTotalPintura());

        return SumaTotal(vehiculo);
    }
}