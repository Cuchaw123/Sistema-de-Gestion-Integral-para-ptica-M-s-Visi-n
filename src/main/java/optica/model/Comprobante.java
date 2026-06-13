package main.java.optica.model;

import java.time.LocalDateTime;


public class Comprobante {

    private String id; // Ej: "B001-000123" o "F001-000456"
    private String tipo; // "BOLETA" o "FACTURA"
    private LocalDateTime fechaEmision;
    private String clienteId;

    // Variables clave para gestión financiera
    private double subtotal;
    private double igv; // Impuesto (18%)
    private double total;

    // Constructor completo (será invocado por el ComprobanteBuilder)
    public Comprobante(String id, String tipo, LocalDateTime fechaEmision, String clienteId, double subtotal, double igv, double total) {
        this.id = id;
        this.tipo = tipo;
        this.fechaEmision = fechaEmision;
        this.clienteId = clienteId;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDateTime getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDateTime fechaEmision) { this.fechaEmision = fechaEmision; }

    public String getClienteId() { return clienteId; }
    public void setClienteId(String clienteId) { this.clienteId = clienteId; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    public double getIgv() { return igv; }
    public void setIgv(double igv) { this.igv = igv; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    @Override
    public String toString() {
        return "Comprobante [" + tipo + " - " + id + "] | Cliente: " + clienteId +
                " | Emisión: " + fechaEmision +
                "\n   Subtotal: S/." + subtotal + " | IGV: S/." + igv + " | TOTAL: S/." + total;
    }
}