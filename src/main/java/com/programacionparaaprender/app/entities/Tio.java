package com.programacionparaaprender.app.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name="tio")
@Cacheable
public class Tio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String email;

    
    @NotNull
    @Column(name="password")
    private String password;
    
    public Tio() {
    }
    
    public Tio(Long id, @NotNull String nombre, @NotNull String email, @NotNull String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public Tio(@NotNull String nombre, @NotNull String email, @NotNull String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

}
