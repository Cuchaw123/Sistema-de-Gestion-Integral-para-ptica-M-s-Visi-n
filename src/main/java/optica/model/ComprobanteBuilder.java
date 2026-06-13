package main.java.optica.model;

import java.time.LocalDateTime;


public class ComprobanteBuilder {

    private String id;
    private String tipo;
    private LocalDateTime fechaEmision;
    private String clienteId;
    private double subtotal;
    private double igv;
    private double total;

    public ComprobanteBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ComprobanteBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public ComprobanteBuilder setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
        return this;
    }

    public ComprobanteBuilder setClienteId(String clienteId) {
        this.clienteId = clienteId;
        return this;
    }

    public ComprobanteBuilder setSubtotal(double subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public ComprobanteBuilder setIgv(double igv) {
        this.igv = igv;
        return this;
    }

    public ComprobanteBuilder setTotal(double total) {
        this.total = total;
        return this;
    }


    public Comprobante build() {
        return new Comprobante(id, tipo, fechaEmision, clienteId, subtotal, igv, total);
    }
}