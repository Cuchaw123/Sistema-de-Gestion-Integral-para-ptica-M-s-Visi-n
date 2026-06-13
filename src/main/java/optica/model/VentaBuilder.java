package main.java.optica.model;

import java.time.LocalDateTime;


public class VentaBuilder {

    private String id;
    private String pacienteId;
    private String usuarioId;
    private String sedeId;
    private LocalDateTime fechaHora;
    private double subTotal;
    private double descuentoTotal;
    private double igv;
    private double total;
    private String estado;

    public VentaBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public VentaBuilder setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
        return this;
    }

    public VentaBuilder setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public VentaBuilder setSedeId(String sedeId) {
        this.sedeId = sedeId;
        return this;
    }

    public VentaBuilder setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
        return this;
    }

    public VentaBuilder setSubTotal(double subTotal) {
        this.subTotal = subTotal;
        return this;
    }

    public VentaBuilder setDescuentoTotal(double descuentoTotal) {
        this.descuentoTotal = descuentoTotal;
        return this;
    }

    public VentaBuilder setIgv(double igv) {
        this.igv = igv;
        return this;
    }

    public VentaBuilder setTotal(double total) {
        this.total = total;
        return this;
    }

    public VentaBuilder setEstado(String estado) {
        this.estado = estado;
        return this;
    }


    public Venta build() {
        return new Venta(id, pacienteId, usuarioId, sedeId, fechaHora, subTotal, descuentoTotal, igv, total, estado);
    }
}