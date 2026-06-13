package main.java.optica.model;

import java.time.LocalDateTime;


public class ComprobanteResponse {

    private String id;
    private String tipo;
    private LocalDateTime fechaEmision;
    private String clienteId;
    private double subtotal;
    private double igv;
    private double total;
    private String estadoMensaje;

    // Constructor vacío
    public ComprobanteResponse() {
    }

    // Constructor completo
    public ComprobanteResponse(String id, String tipo, LocalDateTime fechaEmision, String clienteId,
                               double subtotal, double igv, double total, String estadoMensaje) {
        this.id = id;
        this.tipo = tipo;
        this.fechaEmision = fechaEmision;
        this.clienteId = clienteId;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.estadoMensaje = estadoMensaje;
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

    public String getEstadoMensaje() { return estadoMensaje; }
    public void setEstadoMensaje(String estadoMensaje) { this.estadoMensaje = estadoMensaje; }

    @Override
    public String toString() {
        return "=========================================\n" +
                "         OPTICA MAS VISION S.A.C.        \n" +
                "=========================================\n" +
                " Estado: " + estadoMensaje + "\n" +
                " Documento: " + tipo + " Nro: " + id + "\n" +
                " Fecha Emisión: " + fechaEmision + "\n" +
                " Cliente ID: " + clienteId + "\n" +
                "-----------------------------------------\n" +
                " OP. GRAVADA (Subtotal): S/. " + String.format("%.2f", subtotal) + "\n" +
                " I.G.V. (18%):           S/. " + String.format("%.2f", igv) + "\n" +
                " TOTAL A PAGAR:          S/. " + String.format("%.2f", total) + "\n" +
                "=========================================";
    }
}