package com.taller.presupuesto.presupuesto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import java.util.Set;
import java.util.HashSet;

@Data
@Table(name = "usuarios") // Cambiamos @Entity por @Table de R2DBC
public class Usuario {

    @Id
    @Column("id")
    private Long id;

    @Column("username")
    private String username;

    @Column("password")
    private String password;

    @Column("enabled")
    private boolean enabled = true;

    @MappedCollection(idColumn = "usuario_id")
    private Set<String> roles = new HashSet<>();
}
