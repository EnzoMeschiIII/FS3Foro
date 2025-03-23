package com.example.foro.repository;

import com.example.foro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email); // Buscar usuario por email (clave única en tu entidad)
}