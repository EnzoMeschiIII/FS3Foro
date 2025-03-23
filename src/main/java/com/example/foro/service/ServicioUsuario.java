package com.example.foro.service;

import com.example.foro.model.Usuario;
import com.example.foro.DTO.DTOUsuario;
import com.example.foro.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Optional<Usuario> buscarPorEmail(String email) {
        return repositorioUsuario.findByEmail(email);
    }

    public DTOUsuario guardarUsuario(DTOUsuario dtoUsuario) {
        Usuario usuario = convertirAEntidad(dtoUsuario);
        Usuario usuarioGuardado = repositorioUsuario.save(usuario);
        return convertirADTO(usuarioGuardado);
    }

    public List<DTOUsuario> obtenerTodos() {
        return repositorioUsuario.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public DTOUsuario obtenerPorId(Long id) {
        Optional<Usuario> usuario = repositorioUsuario.findById(id);
        return usuario.map(this::convertirADTO).orElse(null);
    }

    public DTOUsuario actualizarUsuario(Long id, DTOUsuario dtoUsuario) {
        return repositorioUsuario.findById(id)
                .map(usuario -> {
                    Usuario usuarioActualizado = Usuario.builder()
                            .id(id) // Se asigna el id directamente
                            .nombre(dtoUsuario.getNombre())
                            .email(dtoUsuario.getEmail())
                            .contrasena(dtoUsuario.getContrasena())
                            .rol(dtoUsuario.getRol())
                            .build();
                    return convertirADTO(repositorioUsuario.save(usuarioActualizado));
                }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
    

    public void eliminarUsuario(Long id) {
        repositorioUsuario.deleteById(id);
    }

    private Usuario convertirAEntidad(DTOUsuario dtoUsuario) {
        return Usuario.builder()
                .id(dtoUsuario.getId())
                .nombre(dtoUsuario.getNombre())
                .email(dtoUsuario.getEmail())
                .contrasena(dtoUsuario.getContrasena())
                .rol(dtoUsuario.getRol())
                .build();
    }

    private DTOUsuario convertirADTO(Usuario usuario) {
        return DTOUsuario.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .email(usuario.getEmail())
                .contrasena(usuario.getContrasena())
                .rol(usuario.getRol())
                .build();
    }
}
