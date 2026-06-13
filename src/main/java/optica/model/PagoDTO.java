package main.java.optica.model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class PagoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String ventaId;
    private String metodoPago;
    private double montoTotal;
    private double vuelto;
    private LocalDateTime fechaPago;

    // Constructor vacío obligatorio
    public PagoDTO() {
    }

    // Constructor completo
    public PagoDTO(String id, String ventaId, String metodoPago, double montoTotal, double vuelto, LocalDateTime fechaPago) {
        this.id = id;
        this.ventaId = ventaId;
        this.metodoPago = metodoPago;
        this.montoTotal = montoTotal;
        this.vuelto = vuelto;
        this.fechaPago = fechaPago;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVentaId() {
        return ventaId;
    }

    public void setVentaId(String ventaId) {
        this.ventaId = ventaId;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getVuelto() {
        return vuelto;
    }

    public void setVuelto(double vuelto) {
        this.vuelto = vuelto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public String toString() {
        return "PagoDTO{" +
                "id='" + id + '\'' +
                ", ventaId='" + ventaId + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", montoTotal=" + montoTotal +
                ", vuelto=" + vuelto +
                '}';
    }
}