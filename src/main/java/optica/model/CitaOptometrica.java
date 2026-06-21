package main.java.optica.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CitaOptometrica {

    public static final String PENDIENTE = "PENDIENTE";
    public static final String CONFIRMADA = "CONFIRMADA";
    public static final String ATENDIDA = "ATENDIDA";
    public static final String CANCELADA = "CANCELADA";

    private String id;
    private String pacienteId;
    private String optometristaId;
    private LocalDateTime fechaHora;

    // Ej.: "Examen de refracción",
    // "Control de lentes de contacto"
    private String motivo;

    private String estado;

    // Constructor completo utilizado por CitaOptometricaBuilder
    public CitaOptometrica(
            String id,
            String pacienteId,
            String optometristaId,
            LocalDateTime fechaHora,
            String motivo,
            String estado
    ) {
        setId(id);
        setPacienteId(pacienteId);
        setOptometristaId(optometristaId);
        setFechaHora(fechaHora);
        setMotivo(motivo);
        setEstado(estado);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        validarTextoObligatorio(id, "identificador de la cita");
        this.id = id.trim();
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        validarTextoObligatorio(
                pacienteId,
                "identificador del paciente"
        );

        this.pacienteId = pacienteId.trim();
    }

    public String getOptometristaId() {
        return optometristaId;
    }

    public void setOptometristaId(String optometristaId) {
        validarTextoObligatorio(
                optometristaId,
                "identificador del optometrista"
        );

        this.optometristaId = optometristaId.trim();
    }

    @Deprecated
    public String getDoctorId() {
        return optometristaId;
    }

    @Deprecated
    public void setDoctorId(String doctorId) {
        setOptometristaId(doctorId);
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        if (fechaHora == null) {
            throw new IllegalArgumentException(
                    "La fecha y hora de la cita son obligatorias."
            );
        }

        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        validarTextoObligatorio(motivo, "motivo de la cita");
        this.motivo = motivo.trim();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        validarTextoObligatorio(estado, "estado de la cita");

        String estadoNormalizado = estado.trim().toUpperCase();

        if (!esEstadoValido(estadoNormalizado)) {
            throw new IllegalArgumentException(
                    "Estado de cita no válido: " + estado
            );
        }

        this.estado = estadoNormalizado;
    }

    public void confirmar() {
        if (!PENDIENTE.equals(estado)) {
            throw new IllegalStateException(
                    "Solo se puede confirmar una cita pendiente."
            );
        }

        estado = CONFIRMADA;
    }

    public void marcarAtendida() {
        if (!CONFIRMADA.equals(estado)) {
            throw new IllegalStateException(
                    "Solo se puede atender una cita confirmada."
            );
        }

        estado = ATENDIDA;
    }

    public void cancelar() {
        if (ATENDIDA.equals(estado)) {
            throw new IllegalStateException(
                    "Una cita atendida no puede cancelarse."
            );
        }

        if (CANCELADA.equals(estado)) {
            throw new IllegalStateException(
                    "La cita ya se encuentra cancelada."
            );
        }

        estado = CANCELADA;
    }

    public void reprogramar(LocalDateTime nuevaFechaHora) {
        if (nuevaFechaHora == null) {
            throw new IllegalArgumentException(
                    "La nueva fecha y hora son obligatorias."
            );
        }

        if (!nuevaFechaHora.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException(
                    "La nueva fecha debe ser posterior a la fecha actual."
            );
        }

        if (ATENDIDA.equals(estado) || CANCELADA.equals(estado)) {
            throw new IllegalStateException(
                    "No se puede reprogramar una cita finalizada."
            );
        }

        fechaHora = nuevaFechaHora;
        estado = PENDIENTE;
    }

    public boolean estaPendiente() {
        return PENDIENTE.equals(estado);
    }

    public boolean estaFinalizada() {
        return ATENDIDA.equals(estado)
                || CANCELADA.equals(estado);
    }

    public String obtenerFechaHoraFormateada() {
        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return fechaHora.format(formato);
    }

    private boolean esEstadoValido(String estado) {
        return PENDIENTE.equals(estado)
                || CONFIRMADA.equals(estado)
                || ATENDIDA.equals(estado)
                || CANCELADA.equals(estado);
    }

    private void validarTextoObligatorio(
            String valor,
            String campo
    ) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " es obligatorio."
            );
        }
    }

    @Override
    public String toString() {
        return "Cita optométrica [" + id + "]"
                + " | Paciente: " + pacienteId
                + " | Optometrista: " + optometristaId
                + " | Fecha: " + obtenerFechaHoraFormateada()
                + " | Motivo: " + motivo
                + " | Estado: " + estado;
    }
}