package main.java.optica.model;


public class SedeRequest {

    private String distrito;
    private String direccion;
    private String telefono;

    // Constructor vacío
    public SedeRequest() {
    }

    // Constructor completo
    public SedeRequest(String distrito, String direccion, String telefono) {
        this.distrito = distrito;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getDistrito() { return distrito; }
    public void setDistrito(String distrito) { this.distrito = distrito; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}