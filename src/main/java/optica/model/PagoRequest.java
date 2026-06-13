package main.java.optica.model;


public class PagoRequest {

    private String ventaId;
    private String metodoPago;
    private double montoTotal;
    private double montoRecibido;

    // Constructor vacío
    public PagoRequest() {
    }

    // Constructor completo
    public PagoRequest(String ventaId, String metodoPago, double montoTotal, double montoRecibido) {
        this.ventaId = ventaId;
        this.metodoPago = metodoPago;
        this.montoTotal = montoTotal;
        this.montoRecibido = montoRecibido;
    }

    // Getters y Setters
    public String getVentaId() { return ventaId; }
    public void setVentaId(String ventaId) { this.ventaId = ventaId; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }

    public double getMontoRecibido() { return montoRecibido; }
    public void setMontoRecibido(double montoRecibido) { this.montoRecibido = montoRecibido; }
}