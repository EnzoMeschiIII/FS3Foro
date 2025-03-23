package com.example.foro.controller;

import com.example.foro.DTO.DTOUsuario;
import com.example.foro.service.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private ServicioUsuario usuarioServicio;

    @GetMapping
    public List<DTOUsuario> obtenerTodos() {
        return usuarioServicio.obtenerTodos();
    }

    @PostMapping
    public DTOUsuario crearUsuario(@RequestBody DTOUsuario usuario) {
        return usuarioServicio.guardarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public DTOUsuario obtenerPorId(@PathVariable Long id) {
        return usuarioServicio.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public DTOUsuario actualizarUsuario(@PathVariable Long id, @RequestBody DTOUsuario usuario) {
        return usuarioServicio.actualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioServicio.eliminarUsuario(id);
    }
}
