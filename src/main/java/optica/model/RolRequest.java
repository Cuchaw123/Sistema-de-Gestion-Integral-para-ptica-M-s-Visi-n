package main.java.optica.model;


public class RolRequest {

    private String nombre;
    private String descripcion;
    private boolean estado;

    // Constructor vacío obligatorio
    public RolRequest() {
    }

    // Constructor completo
    public RolRequest(String nombre, String descripcion, boolean estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}