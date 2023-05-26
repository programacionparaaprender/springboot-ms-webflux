package com.programacionparaaprender.app.repository;

import com.programacionparaaprender.app.entities.Tio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TioRepository extends JpaRepository<Tio, Long> {
    Optional<Tio> findByNombre(String nombre);
    Optional<Tio> findByEmail(String email);
    boolean existsByNombre(String nombre);
    boolean existsByEmail(String email);
}