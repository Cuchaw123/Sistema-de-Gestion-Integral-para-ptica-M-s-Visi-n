package main.java.optica.model;


public class DescuentoResponse {

    private String id;
    private String nombre;
    private String detalleValor; // Ej: "15.0%" o "S/. 20.0"
    private String estado;       // "ACTIVO" o "INACTIVO"
    private String mensaje;      // Mensaje de éxito o error en el proceso

    // Constructor vacío
    public DescuentoResponse() {
    }

    // Constructor completo
    public DescuentoResponse(String id, String nombre, String detalleValor, String estado, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.detalleValor = detalleValor;
        this.estado = estado;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDetalleValor() { return detalleValor; }
    public void setDetalleValor(String detalleValor) { this.detalleValor = detalleValor; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String toString() {
        return "=== APLICACIÓN DE DESCUENTO ===\n" +
                " Operación: " + mensaje + "\n" +
                " Código Promoción: " + id + "\n" +
                " Campaña: " + nombre + "\n" +
                " Beneficio: " + detalleValor + " | Estado: " + estado + "\n" +
                "================================";
    }
}