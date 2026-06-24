package main.java.optica.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CitaOptometricaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String pacienteId;
    private String optometristaId;
    private LocalDateTime fechaHora;
    private String motivo;
    private String estado;

    // Constructor vacío necesario para serialización
    public CitaOptometricaDTO() {
    }

    public CitaOptometricaDTO(
            String id,
            String pacienteId,
            String optometristaId,
            LocalDateTime fechaHora,
            String motivo,
            String estado
    ) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.optometristaId = optometristaId;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CitaOptometricaDTO{"
                + "id='" + id + '\''
                + ", pacienteId='" + pacienteId + '\''
                + ", optometristaId='" + optometristaId + '\''
                + ", fechaHora=" + fechaHora
                + ", motivo='" + motivo + '\''
                + ", estado='" + estado + '\''
                + '}';
    }
}
