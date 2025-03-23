package com.example.foro.DTO;

public class DTOUsuario {

    private Long id;
    private String nombre;
    private String email;
    private String contrasena; // Agregar la propiedad contrasena
    private String rol;

    // Constructor privado para el Builder
    private DTOUsuario(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.email = builder.email;
        this.contrasena = builder.contrasena;  // Agregar contrasena
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
        private String contrasena;  // Agregar contrasena
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

        public DTOUsuario build() {
            return new DTOUsuario(this);
        }
    }

    // Getters y setters
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

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
