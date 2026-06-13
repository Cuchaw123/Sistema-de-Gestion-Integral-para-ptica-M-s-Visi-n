package main.java.optica.model;

import java.time.LocalDateTime;


public class AccesorioResponse {

    private String id;
    private String nombre;
    private double precio;
    private String mensaje;
    private LocalDateTime timestamp;

    // Constructor vacío
    public AccesorioResponse() {
    }

    // Constructor completo
    public AccesorioResponse(String id, String nombre, double precio, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.mensaje = mensaje;
        this.timestamp = LocalDateTime.now(); // Captura el momento exacto de la respuesta
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "=== RESPUESTA DEL SISTEMA ===\n" +
                "Estado: " + mensaje + "\n" +
                "ID: " + id + " | Producto: " + nombre + " | Precio: S/." + precio + "\n" +
                "Fecha/Hora: " + timestamp + "\n" +
                "=============================";
    }
}