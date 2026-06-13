package main.java.optica.model;

import java.time.LocalDateTime;


public class Venta {

    private String id;
    private String pacienteId;     // Enlace con la entidad Paciente
    private String usuarioId;      // Enlace con el Usuario (Cajero/Vendedor) que opera
    private String sedeId;         // Enlace con la Sede física de la transacción
    private LocalDateTime fechaHora;
    private double subTotal;       // Monto antes de impuestos y descuentos
    private double descuentoTotal; // Monto rebajado por promociones o cupones
    private double igv;            // Impuesto General a las Ventas calculado
    private double total;          // Monto neto final cobrado al cliente
    private String estado;         // Ej: "COMPLETADA", "ANULADA", "PENDIENTE_ENTREGA"

    // Constructor completo (será invocado por el VentaBuilder)
    public Venta(String id, String pacienteId, String usuarioId, String sedeId, LocalDateTime fechaHora,
                 double subTotal, double descuentoTotal, double igv, double total, String estado) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.usuarioId = usuarioId;
        this.sedeId = sedeId;
        this.fechaHora = fechaHora;
        this.subTotal = subTotal;
        this.descuentoTotal = descuentoTotal;
        this.igv = igv;
        this.total = total;
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPacienteId() { return pacienteId; }
    public void setPacienteId(String pacienteId) { this.pacienteId = pacienteId; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getSedeId() { return sedeId; }
    public void setSedeId(String sedeId) { this.sedeId = sedeId; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public double getSubTotal() { return subTotal; }
    public void setSubTotal(double subTotal) { this.subTotal = subTotal; }

    public double getDescuentoTotal() { return descuentoTotal; }
    public void setDescuentoTotal(double descuentoTotal) { this.descuentoTotal = descuentoTotal; }

    public double getIgv() { return igv; }
    public void setIgv(double igv) { this.igv = igv; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Venta [" + id + "] | Estado: " + estado + " | Fecha: " + fechaHora +
                "\n  SubTotal: S/. " + subTotal + " | Desc: S/. " + descuentoTotal + " | IGV: S/. " + igv +
                "\n  TOTAL NETO: S/. " + total;
    }
}