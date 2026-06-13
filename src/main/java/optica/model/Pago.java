package main.java.optica.model;

import java.time.LocalDateTime;


public class Pago {

    private String id;
    private String ventaId;       // Enlace directo con la boleta o factura
    private String metodoPago;     // Ej: "EFECTIVO", "TARJETA", "YAPE", "PLIN"
    private double montoTotal;     // Lo que se debe cobrar
    private double montoRecibido;  // Dinero entregado por el cliente
    private double vuelto;         // Diferencia a retornar
    private LocalDateTime fechaPago;

    // Constructor completo (será invocado por el PagoBuilder)
    public Pago(String id, String ventaId, String metodoPago, double montoTotal, double montoRecibido, double vuelto, LocalDateTime fechaPago) {
        this.id = id;
        this.ventaId = ventaId;
        this.metodoPago = metodoPago;
        this.montoTotal = montoTotal;
        this.montoRecibido = montoRecibido;
        this.vuelto = vuelto;
        this.fechaPago = fechaPago;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getVentaId() { return ventaId; }
    public void setVentaId(String ventaId) { this.ventaId = ventaId; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }

    public double getMontoRecibido() { return montoRecibido; }
    public void setMontoRecibido(double montoRecibido) { this.montoRecibido = montoRecibido; }

    public double getVuelto() { return vuelto; }
    public void setVuelto(double vuelto) { this.vuelto = vuelto; }

    public LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }

    @Override
    public String toString() {
        return "Pago [" + id + "] | Venta ID: " + ventaId + " | Método: " + metodoPago +
                "\n  Total: S/. " + montoTotal + " | Pagó con: S/. " + montoRecibido + " | Vuelto: S/. " + vuelto +
                "\n  Fecha: " + fechaPago;
    }
}