package main.java.optica.model;

import java.io.Serializable;


public class SedeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nombre;
    private String direccion;

    // Constructor vacío obligatorio
    public SedeDTO() {
    }

    // Constructor completo
    public SedeDTO(String id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "SedeDTO {" +
                "ID='" + id + '\'' +
                ", Local='" + nombre + '\'' +
                ", Ubicación='" + direccion + '\'' +
                '}';
    }
}