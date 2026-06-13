package main.java.optica.model;

import java.time.LocalDateTime;


public class Reporte {

    private String id;
    private String tipoReporte;      // Ej: "CIERRE_CAJA", "STOCK_CRITICO", "AUDITORIA_MEDICA"
    private String usuarioGenerador; // ID del administrador o cajero que lo solicita
    private int totalTransacciones;  // Cantidad de operaciones procesadas en el periodo
    private double montoTotalSoles;  // Sumatoria total de dinero recaudado
    private String contenidoDetalle; // Bloque de texto con el desglose de métricas
    private LocalDateTime fechaGeneracion;

    // Constructor completo (será invocado por el ReporteBuilder)
    public Reporte(String id, String tipoReporte, String usuarioGenerador, int totalTransacciones,
                   double montoTotalSoles, String contenidoDetalle, LocalDateTime fechaGeneracion) {
        this.id = id;
        this.tipoReporte = tipoReporte;
        this.usuarioGenerador = usuarioGenerador;
        this.totalTransacciones = totalTransacciones;
        this.montoTotalSoles = montoTotalSoles;
        this.contenidoDetalle = contenidoDetalle;
        this.fechaGeneracion = fechaGeneracion;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTipoReporte() { return tipoReporte; }
    public void setTipoReporte(String tipoReporte) { this.tipoReporte = tipoReporte; }

    public String getUsuarioGenerador() { return usuarioGenerador; }
    public void setUsuarioGenerador(String usuarioGenerador) { this.usuarioGenerador = usuarioGenerador; }

    public int getTotalTransacciones() { return totalTransacciones; }
    public void setTotalTransacciones(int totalTransacciones) { this.totalTransacciones = totalTransacciones; }

    public double getMontoTotalSoles() { return montoTotalSoles; }
    public void setMontoTotalSoles(double montoTotalSoles) { this.montoTotalSoles = montoTotalSoles; }

    public String getContenidoDetalle() { return contenidoDetalle; }
    public void setContenidoDetalle(String contenidoDetalle) { this.contenidoDetalle = contenidoDetalle; }

    public LocalDateTime getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(LocalDateTime fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    @Override
    public String toString() {
        return "Reporte [" + id + "] Tipo: " + tipoReporte + " | Fecha: " + fechaGeneracion +
                "\n  Generado por: " + usuarioGenerador +
                "\n  Transacciones: " + totalTransacciones + " | Recaudación: S/. " + montoTotalSoles +
                "\n  Resumen: " + contenidoDetalle;
    }
}