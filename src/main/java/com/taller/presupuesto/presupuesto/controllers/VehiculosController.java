package com.taller.presupuesto.presupuesto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.taller.presupuesto.presupuesto.models.Vehiculos;
import com.taller.presupuesto.presupuesto.service.VehiculosService;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculosController {

    @Autowired
    private VehiculosService vehiculosService;

    @GetMapping
    public Flux<Vehiculos> listarVehiculos() {
        return vehiculosService.listarVehiculos();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Vehiculos>> obtenerVehiculo(@PathVariable Long id) {
        return vehiculosService.buscarPorId(id)
                .map(vehiculo -> new ResponseEntity<>(vehiculo, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Mono<ResponseEntity<Vehiculos>> crearVehiculos(@RequestBody Vehiculos vehiculo) {
        vehiculo.setTotal(vehiculo.getTotalChaperia() + vehiculo.getTotalPintura());
        return vehiculosService.guardar(vehiculo)
                .map(savedVehiculo -> new ResponseEntity<>(savedVehiculo, HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Vehiculos>> actualizarVehiculo(@PathVariable Long id, @RequestBody Vehiculos vehiculo) {
        return vehiculosService.buscarPorId(id)
                .flatMap(vehiculoExistente -> {
                    vehiculoExistente.setVehiculoModelo(vehiculo.getVehiculoModelo());
                    vehiculoExistente.setTotalChaperia(vehiculo.getTotalChaperia());
                    vehiculoExistente.setTotalPintura(vehiculo.getTotalPintura());
                    vehiculoExistente.setTotal(vehiculo.getTotal());
                    return vehiculosService.guardar(vehiculoExistente);
                })
                .map(updatedVehiculo -> new ResponseEntity<>(updatedVehiculo, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> eliminarVehiculo(@PathVariable Long id) {
        return vehiculosService.eliminar(id)
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
    }
}