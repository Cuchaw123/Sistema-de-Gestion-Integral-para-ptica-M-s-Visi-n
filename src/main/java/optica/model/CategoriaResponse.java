package main.java.optica.model;

import java.time.LocalDateTime;

public class CategoriaResponse {

    private String id;
    private String nombre;
    private String descripcion;
    private String mensaje;
    private LocalDateTime timestamp;

    public CategoriaResponse() {
    }

    public CategoriaResponse(String id, String nombre, String descripcion, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.mensaje = mensaje;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "=== ESTADO DE CATEGORÍA ===\n" +
                "Mensaje: " + mensaje + "\n" +
                "ID: " + id + " | Nombre: " + nombre + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Fecha/Hora: " + timestamp + "\n" +
                "===========================";
    }
}