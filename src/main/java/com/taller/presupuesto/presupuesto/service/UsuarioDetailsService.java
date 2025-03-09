package com.taller.presupuesto.presupuesto.service;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taller.presupuesto.presupuesto.repository.UsuarioRepository;

import reactor.core.publisher.Mono;

@Service
public class UsuarioDetailsService implements ReactiveUserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return usuarioRepository.findByUsername(username)
            .switchIfEmpty(Mono.error(new UsernameNotFoundException("Usuario no encontrado")))
            .map(usuario -> User.withUsername(usuario.getUsername())
                .password(usuario.getPassword())
                .disabled(!usuario.isEnabled())
                .roles(usuario.getRoles().toArray(new String[0]))
                .build()
            );
    }
}
