package main.java.optica.model;


public class PagoResponse {

    private String idOperacion;
    private String ventaId;
    private String metodoUsado;
    private double totalCobrado;
    private double vueltoEntregado;
    private String estadoTransaccion;

    // Constructor vacío
    public PagoResponse() {
    }

    // Constructor completo
    public PagoResponse(String idOperacion, String ventaId, String metodoUsado, double totalCobrado, double vueltoEntregado, String estadoTransaccion) {
        this.idOperacion = idOperacion;
        this.ventaId = ventaId;
        this.metodoUsado = metodoUsado;
        this.totalCobrado = totalCobrado;
        this.vueltoEntregado = vueltoEntregado;
        this.estadoTransaccion = estadoTransaccion;
    }

    // Getters y Setters
    public String getIdOperacion() { return idOperacion; }
    public void setIdOperacion(String idOperacion) { this.idOperacion = idOperacion; }

    public String getVentaId() { return ventaId; }
    public void setVentaId(String ventaId) { this.ventaId = ventaId; }

    public String getMetodoUsado() { return metodoUsado; }
    public void setMetodoUsado(String metodoUsado) { this.metodoUsado = metodoUsado; }

    public double getTotalCobrado() { return totalCobrado; }
    public void setTotalCobrado(double totalCobrado) { this.totalCobrado = totalCobrado; }

    public double getVueltoEntregado() { return vueltoEntregado; }
    public void setVueltoEntregado(double vueltoEntregado) { this.vueltoEntregado = vueltoEntregado; }

    public String getEstadoTransaccion() { return estadoTransaccion; }
    public void setEstadoTransaccion(String estadoTransaccion) { this.estadoTransaccion = estadoTransaccion; }

    @Override
    public String toString() {
        return "=======================================\n" +
                "         COMPROBANTE DE PAGO           \n" +
                "=======================================\n" +
                " Op. Caja:   " + idOperacion + "\n" +
                " Ticket Ref: " + ventaId + "\n" +
                " Estado:     " + estadoTransaccion + "\n" +
                "---------------------------------------\n" +
                " Canal Pago: " + metodoUsado + "\n" +
                " TOTAL:      S/. " + String.format("%.2f", totalCobrado) + "\n" +
                " VUELTO:     S/. " + String.format("%.2f", vueltoEntregado) + "\n" +
                "=======================================\n";
    }
}