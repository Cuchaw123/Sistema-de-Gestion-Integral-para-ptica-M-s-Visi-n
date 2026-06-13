package main.java.optica.model;


public class AccesorioRequest {

    private String id;
    private String nombre;
    private double precio;

    // Constructor vacío
    public AccesorioRequest() {
    }

    // Constructor con parámetros
    public AccesorioRequest(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
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
}