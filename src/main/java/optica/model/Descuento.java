package main.java.optica.model;


public class Descuento {

    private String id;          // Ej: "DESC-15", "CUPON-20"
    private String nombre;      // Ej: "Descuento Campaña Sol"
    private String tipo;        // "PORCENTAJE" o "MONTO_FIJO"
    private double valor;       // Ej: 15.00 (para 15%) o 20.00 (para S/.20 de rebaja)
    private boolean activo;     // Para habilitar o deshabilitar la promoción

    // Constructor completo (será invocado por el DescuentoBuilder)
    public Descuento(String id, String nombre, String tipo, double valor, boolean activo) {
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

    @Override
    public String toString() {
        String detalleValor = this.tipo.equalsIgnoreCase("PORCENTAJE") ? valor + "%" : "S/. " + valor;
        String estado = activo ? "ACTIVO" : "INACTIVO";
        return "Descuento [" + id + "] : " + nombre + " | Valor: " + detalleValor + " | Estado: " + estado;
    }
}