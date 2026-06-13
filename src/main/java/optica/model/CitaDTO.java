package main.java.optica.model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class CitaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String pacienteId;
    private String doctorId;
    private LocalDateTime fechaHora;
    private String motivo;
    private String estado;

    // Constructor vacío obligatorio
    public CitaDTO() {
    }

    // Constructor completo
    public CitaDTO(String id, String pacienteId, String doctorId, LocalDateTime fechaHora, String motivo, String estado) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CitaDTO{" +
                "id='" + id + '\'' +
                ", pacienteId='" + pacienteId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", fechaHora=" + fechaHora +
                ", motivo='" + motivo + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}