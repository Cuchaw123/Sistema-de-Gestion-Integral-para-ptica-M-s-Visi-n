package main.java.optica.model;


public class VentaRequest {

    private String pacienteId;
    private String usuarioId;
    private String sedeId;
    private double montoTotal;
    private double descuento;

    // Constructor vacío obligatorio
    public VentaRequest() {
    }

    // Constructor completo
    public VentaRequest(String pacienteId, String usuarioId, String sedeId, double montoTotal, double descuento) {
        this.pacienteId = pacienteId;
        this.usuarioId = usuarioId;
        this.sedeId = sedeId;
        this.montoTotal = montoTotal;
        this.descuento = descuento;
    }

    // Getters y Setters
    public String getPacienteId() { return pacienteId; }
    public void setPacienteId(String pacienteId) { this.pacienteId = pacienteId; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getSedeId() { return sedeId; }
    public void setSedeId(String sedeId) { this.sedeId = sedeId; }

    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) { this.descuento = descuento; }
}