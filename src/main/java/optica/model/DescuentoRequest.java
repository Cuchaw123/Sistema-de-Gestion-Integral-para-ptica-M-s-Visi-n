package main.java.optica.model;


public class DescuentoRequest {

    private String id;
    private String nombre;
    private String tipo; // "PORCENTAJE" o "MONTO_FIJO"
    private double valor;
    private boolean activo;

    // Constructor vacío
    public DescuentoRequest() {
    }

    // Constructor completo
    public DescuentoRequest(String id, String nombre, String tipo, double valor, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.activo = activo;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}