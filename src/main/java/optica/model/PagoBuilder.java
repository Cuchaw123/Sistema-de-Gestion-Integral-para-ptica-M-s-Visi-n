package main.java.optica.model;

import java.time.LocalDateTime;


public class PagoBuilder {

    private String id;
    private String ventaId;
    private String metodoPago;
    private double montoTotal;
    private double montoRecibido;
    private double vuelto;
    private LocalDateTime fechaPago;

    public PagoBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public PagoBuilder setVentaId(String ventaId) {
        this.ventaId = ventaId;
        return this;
    }

    public PagoBuilder setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
        return this;
    }

    public PagoBuilder setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
        return this;
    }

    public PagoBuilder setMontoRecibido(double montoRecibido) {
        this.montoRecibido = montoRecibido;
        return this;
    }

    public PagoBuilder setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
        return this;
    }


    public Pago build() {
        // Regla de negocio: El vuelto se calcula automáticamente
        this.vuelto = this.montoRecibido - this.montoTotal;
        if (this.vuelto < 0) {
            this.vuelto = 0.0; // Evita vueltos negativos en transacciones digitales exactas
        }
        return new Pago(id, ventaId, metodoPago, montoTotal, montoRecibido, vuelto, fechaPago);
    }
}