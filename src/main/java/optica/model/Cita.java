package main.java.optica.model;

import java.time.LocalDateTime;

/**
 * Entidad que representa una Cita Médica/Optométrica en la Óptica Más Visión.
 */
public class Cita {

    private String id;
    private String pacienteId;
    private String doctorId;
    private LocalDateTime fechaHora;
    private String motivo;  // Ej: "Examen de refracción", "Control de lentes de contacto"
    private String estado;  // Ej: "PENDIENTE", "ATENDIDA", "CANCELADA"

    // Constructor completo (será invocado por el CitaBuilder)
    public Cita(String id, String pacienteId, String doctorId, LocalDateTime fechaHora, String motivo, String estado) {
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
        return "Cita [" + id + "] | Paciente ID: " + pacienteId + " | Doctor ID: " + doctorId +
                " | Fecha: " + fechaHora + " | Motivo: " + motivo + " | Estado: " + estado;
    }
}