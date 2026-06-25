package main.java.optica.model;

import java.time.LocalDateTime;

public class CitaOptometricaResponse {

    private String id;
    private String pacienteId;
    private String optometristaId;
    private LocalDateTime fechaHora;
    private String estado;
    private String mensaje;
    private LocalDateTime timestamp;

    public CitaOptometricaResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public CitaOptometricaResponse(
            String id,
            String pacienteId,
            String optometristaId,
            LocalDateTime fechaHora,
            String estado,
            String mensaje
    ) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.optometristaId = optometristaId;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.mensaje = mensaje;
        this.timestamp = LocalDateTime.now();
    }

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

    public String getOptometristaId() {
        return optometristaId;
    }

    public void setOptometristaId(String optometristaId) {
        this.optometristaId = optometristaId;
    }

    /*
     * Compatibilidad temporal con clases antiguas.
     */
    @Deprecated
    public String getDoctorId() {
        return optometristaId;
    }

    @Deprecated
    public void setDoctorId(String doctorId) {
        this.optometristaId = doctorId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "=== TICKET DE CITA OPTOMÉTRICA ===\n" +
                "Resultado: " + mensaje + "\n" +
                "ID Cita: " + id +
                " | Estado: " + estado + "\n" +
                "Paciente ID: " + pacienteId + "\n" +
                "Optometrista ID: " + optometristaId + "\n" +
                "Fecha programada: " + fechaHora + "\n" +
                "Registro generado: " + timestamp + "\n" +
                "===================================";
    }
}