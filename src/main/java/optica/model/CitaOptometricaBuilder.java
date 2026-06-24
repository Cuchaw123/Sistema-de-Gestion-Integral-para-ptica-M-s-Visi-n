package main.java.optica.model;

import java.time.LocalDateTime;

public class CitaOptometricaBuilder {

    private String id;
    private String pacienteId;
    private String optometristaId;
    private LocalDateTime fechaHora;
    private String motivo;
    private String estado = CitaOptometrica.PENDIENTE;

    public CitaOptometricaBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public CitaOptometricaBuilder setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
        return this;
    }

    public CitaOptometricaBuilder setOptometristaId(
            String optometristaId
    ) {
        this.optometristaId = optometristaId;
        return this;
    }

    @Deprecated
    public CitaOptometricaBuilder setDoctorId(String doctorId) {
        return setOptometristaId(doctorId);
    }

    public CitaOptometricaBuilder setFechaHora(
            LocalDateTime fechaHora
    ) {
        this.fechaHora = fechaHora;
        return this;
    }

    public CitaOptometricaBuilder setMotivo(String motivo) {
        this.motivo = motivo;
        return this;
    }

    public CitaOptometricaBuilder setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public CitaOptometrica build() {
        return new CitaOptometrica(
                id,
                pacienteId,
                optometristaId,
                fechaHora,
                motivo,
                estado
        );
    }
}
