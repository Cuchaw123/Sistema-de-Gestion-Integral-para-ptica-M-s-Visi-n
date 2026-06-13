package main.java.optica.model;

/**
 * Clase Request para encapsular los datos de entrada
 * al solicitar la emisión de una nueva Boleta o Factura.
 */
public class ComprobanteRequest {

    private String tipo; // "BOLETA" o "FACTURA"
    private String clienteId;
    private double montoTotal;

    // Constructor vacío
    public ComprobanteRequest() {
    }

    // Constructor con parámetros
    public ComprobanteRequest(String tipo, String clienteId, double montoTotal) {
        this.tipo = tipo;
        this.clienteId = clienteId;
        this.montoTotal = montoTotal;
    }

    // Getters y Setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getClienteId() { return clienteId; }
    public void setClienteId(String clienteId) { this.clienteId = clienteId; }

    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }
}