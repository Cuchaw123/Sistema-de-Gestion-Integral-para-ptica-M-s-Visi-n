package main.java.optica.model;


public class Sede {

    private String id;
    private String nombre;    // Ej: "Sede Miraflores", "Sede San Isidro"
    private String direccion; // Ej: "Av. Larco 456", "Av. Javier Prado 1020"
    private String telefono;  // Teléfono de contacto directo del local
    private boolean activa;   // true = Operando, false = Cerrada temporalmente

    // Constructor completo
    public Sede(String id, String nombre, String direccion, String telefono, boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.activa = activa;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

    @Override
    public String toString() {
        return "Sede [" + id + "] " + nombre + " | Estado: " + (activa ? "Abierta" : "Cerrada") +
                "\n  Dirección: " + direccion + " | Telf: " + telefono;
    }
}