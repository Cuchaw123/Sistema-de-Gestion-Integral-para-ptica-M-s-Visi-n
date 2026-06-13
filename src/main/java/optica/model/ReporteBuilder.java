package main.java.optica.model;

import java.time.LocalDateTime;


public class ReporteBuilder {

    private String id;
    private String tipoReporte;
    private String usuarioGenerador;
    private int totalTransacciones;
    private double montoTotalSoles;
    private String contenidoDetalle;
    private LocalDateTime fechaGeneracion;

    public ReporteBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ReporteBuilder setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
        return this;
    }

    public ReporteBuilder setUsuarioGenerador(String usuarioGenerador) {
        this.usuarioGenerador = usuarioGenerador;
        return this;
    }

    public ReporteBuilder setTotalTransacciones(int totalTransacciones) {
        this.totalTransacciones = totalTransacciones;
        return this;
    }

    public ReporteBuilder setMontoTotalSoles(double montoTotalSoles) {
        this.montoTotalSoles = montoTotalSoles;
        return this;
    }

    public ReporteBuilder setContenidoDetalle(String contenidoDetalle) {
        this.contenidoDetalle = contenidoDetalle;
        return this;
    }

    public ReporteBuilder setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
        return this;
    }


    public Reporte build() {
        return new Reporte(id, tipoReporte, usuarioGenerador, totalTransacciones,
                montoTotalSoles, contenidoDetalle, fechaGeneracion);
    }
}