package main.java.optica.model;

import java.time.LocalDateTime;

public class CitaOptometricaRequest {

    private String pacienteId;
    private String optometristaId;
    private LocalDateTime fechaHora;
    private String motivo;

    public CitaOptometricaRequest() {
    }

    public CitaOptometricaRequest(
            String pacienteId,
            String optometristaId,
            LocalDateTime fechaHora,
            String motivo
    ) {
        this.pacienteId = pacienteId;
        this.optometristaId = optometristaId;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "CitaOptometricaRequest{" +
                "pacienteId='" + pacienteId + '\'' +
                ", optometristaId='" + optometristaId + '\'' +
                ", fechaHora=" + fechaHora +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
