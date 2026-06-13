package main.java.optica.model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class ComprobanteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String tipo;
    private LocalDateTime fechaEmision;
    private String clienteId;
    private double subtotal;
    private double igv;
    private double total;

    // Constructor vacío obligatorio
    public ComprobanteDTO() {
    }

    // Constructor completo
    public ComprobanteDTO(String id, String tipo, LocalDateTime fechaEmision, String clienteId, double subtotal, double igv, double total) {
        this.id = id;
        this.tipo = tipo;
        this.fechaEmision = fechaEmision;
        this.clienteId = clienteId;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ComprobanteDTO{" +
                "id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fechaEmision=" + fechaEmision +
                ", clienteId='" + clienteId + '\'' +
                ", subtotal=" + subtotal +
                ", igv=" + igv +
                ", total=" + total +
                '}';
    }
}