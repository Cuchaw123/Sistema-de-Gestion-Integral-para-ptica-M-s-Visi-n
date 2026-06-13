package main.java.optica.model;

import java.time.LocalDateTime;

/**
 * Response para enviar la confirmación de la cita a la interfaz de usuario.
 */
public class CitaResponse {

    private String id;
    private String pacienteId;
    private String doctorId;
    private LocalDateTime fechaHora;
    private String estado;
    private String mensaje;
    private LocalDateTime timestamp;

    public CitaResponse() {
    }

    public CitaResponse(String id, String pacienteId, String doctorId, LocalDateTime fechaHora, String estado, String mensaje) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.mensaje = mensaje;
        this.timestamp = LocalDateTime.now();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPacienteId() { return pacienteId; }
    public void setPacienteId(String pacienteId) { this.pacienteId = pacienteId; }

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "=== TICKET DE CITA ===\n" +
                "Estado de operación: " + mensaje + "\n" +
                "ID Cita: " + id + " | Estado: " + estado + "\n" +
                "Paciente ID: " + pacienteId + " | Doctor ID: " + doctorId + "\n" +
                "Fecha programada: " + fechaHora + "\n" +
                "======================";
    }
}