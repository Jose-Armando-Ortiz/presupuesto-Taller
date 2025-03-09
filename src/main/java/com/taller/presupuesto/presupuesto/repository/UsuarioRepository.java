package com.taller.presupuesto.presupuesto.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.taller.presupuesto.presupuesto.models.Usuario;

import reactor.core.publisher.Mono;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Long> {
    Mono<Usuario> findByUsername(String username);
}
