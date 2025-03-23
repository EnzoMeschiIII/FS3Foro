package com.example.foro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;

    @Column(name = "rol", nullable = false, length = 50)
    private String rol;

    // Constructor privado para el Builder
    private Usuario(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.email = builder.email;
        this.contrasena = builder.contrasena;
        this.rol = builder.rol;
    }

    // Método estático para iniciar la construcción
    public static Builder builder() {
        return new Builder();
    }

    // Clase estática Builder
    public static class Builder {
        private Long id;
        private String nombre;
        private String email;
        private String contrasena;
        private String rol;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder contrasena(String contrasena) {
            this.contrasena = contrasena;
            return this;
        }

        public Builder rol(String rol) {
            this.rol = rol;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }
}