package main.java.optica.model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class ReporteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String tipoReporte;
    private LocalDateTime fechaGeneracion;
    private int totalTransacciones;
    private double montoTotalSoles;

    // Constructor vacío obligatorio
    public ReporteDTO() {
    }

    // Constructor completo
    public ReporteDTO(String id, String tipoReporte, LocalDateTime fechaGeneracion, int totalTransacciones, double montoTotalSoles) {
        this.id = id;
        this.tipoReporte = tipoReporte;
        this.fechaGeneracion = fechaGeneracion;
        this.totalTransacciones = totalTransacciones;
        this.montoTotalSoles = montoTotalSoles;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public int getTotalTransacciones() {
        return totalTransacciones;
    }

    public void setTotalTransacciones(int totalTransacciones) {
        this.totalTransacciones = totalTransacciones;
    }

    public double getMontoTotalSoles() {
        return montoTotalSoles;
    }

    public void setMontoTotalSoles(double montoTotalSoles) {
        this.montoTotalSoles = montoTotalSoles;
    }

    @Override
    public String toString() {
        return "ReporteDTO {" +
                "ID='" + id + '\'' +
                ", Tipo='" + tipoReporte + '\'' +
                ", Transacciones=" + totalTransacciones +
                ", Total Recaudado=S/. " + String.format("%.2f", montoTotalSoles) +
                '}';
    }
}