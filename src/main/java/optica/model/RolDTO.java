package main.java.optica.model;

import java.io.Serializable;


public class RolDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nombre;
    private boolean estado;


    public RolDTO() {
    }

    // Constructor completo
    public RolDTO(String id, String nombre, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "RolDTO {" +
                "ID='" + id + '\'' +
                ", Perfil='" + nombre + '\'' +
                ", Activo=" + estado +
                '}';
    }
}