package main.java.optica.model;

import java.time.LocalDateTime;


public class CitaRequest {

    private String pacienteId;
    private String doctorId;
    private LocalDateTime fechaHora;
    private String motivo;

    // Constructor vacío
    public CitaRequest() {
    }

    // Constructor con parámetros
    public CitaRequest(String pacienteId, String doctorId, LocalDateTime fechaHora, String motivo) {
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }

    // Getters y Setters
    public String getPacienteId() { return pacienteId; }
    public void setPacienteId(String pacienteId) { this.pacienteId = pacienteId; }

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}