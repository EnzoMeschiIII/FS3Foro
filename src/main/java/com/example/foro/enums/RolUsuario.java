package com.example.foro.enums;

public enum RolUsuario {
    ADMIN,     // Puede hacer todo
    MODERADOR, // Puede moderar posts y comentarios, pero no administrar usuarios
    USUARIO    // Solo puede crear/editar sus propios posts y comentarios
}
