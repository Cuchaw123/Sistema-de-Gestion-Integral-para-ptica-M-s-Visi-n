package main.java.optica.model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class VentaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private LocalDateTime fechaHora;
    private double total;
    private String estado;

    // Constructor vacío obligatorio
    public VentaDTO() {
    }

    // Constructor completo
    public VentaDTO(String id, LocalDateTime fechaHora, double total, String estado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.total = total;
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "VentaDTO {" +
                "Boleta ID='" + id + '\'' +
                ", Emisión=" + fechaHora +
                ", Total Cobrado=S/. " + total +
                ", Estado='" + estado + '\'' +
                '}';
    }
}