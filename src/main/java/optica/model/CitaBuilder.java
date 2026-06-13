package main.java.optica.model;

import java.time.LocalDateTime;


public class CitaBuilder {

    private String id;
    private String pacienteId;
    private String doctorId;
    private LocalDateTime fechaHora;
    private String motivo;
    private String estado;

    public CitaBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public CitaBuilder setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
        return this;
    }

    public CitaBuilder setDoctorId(String doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public CitaBuilder setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
        return this;
    }

    public CitaBuilder setMotivo(String motivo) {
        this.motivo = motivo;
        return this;
    }

    public CitaBuilder setEstado(String estado) {
        this.estado = estado;
        return this;
    }


    public Cita build() {
        return new Cita(id, pacienteId, doctorId, fechaHora, motivo, estado);
    }
}