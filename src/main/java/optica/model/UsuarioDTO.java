package main.java.optica.model;

import java.io.Serializable;


public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nombreCompleto;
    private String username;
    private String nombreRol; // Mapeado directo para facilitar la lectura en consola

    // Constructor vacío obligatorio
    public UsuarioDTO() {
    }

    // Constructor completo
    public UsuarioDTO(String id, String nombreCompleto, String username, String nombreRol) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.nombreRol = nombreRol;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public String toString() {
        return "UsuarioDTO {" +
                "ID='" + id + '\'' +
                ", Nombre='" + nombreCompleto + '\'' +
                ", Cuenta='@" + username + '\'' +
                ", Rol='" + nombreRol + '\'' +
                '}';
    }
}