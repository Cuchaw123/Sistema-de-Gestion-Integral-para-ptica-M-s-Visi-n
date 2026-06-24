package main.java.optica.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class CitaOptometricaFactory {

    public static CitaOptometrica crearCitaOptometrica(
            String tipo,
            String pacienteId,
            String optometristaId,
            LocalDateTime fechaHora
    ) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException(
                    "El tipo de cita es obligatorio."
            );
        }

        String idGenerado = "CIT-"
                + UUID.randomUUID()
                .toString()
                .substring(0, 6)
                .toUpperCase();

        String motivo;

        switch (tipo.trim().toUpperCase()) {
            case "CONTROL":
                motivo = "Control de graduación visual";
                break;

            case "LENTES_CONTACTO":
                motivo = "Control de lentes de contacto";
                break;

            case "ENTREGA":
                motivo = "Entrega y ajuste de montura";
                break;

            case "REFRACCION":
                motivo = "Examen de refracción";
                break;

            default:
                motivo = "Evaluación optométrica completa";
                break;
        }

        return new CitaOptometricaBuilder()
                .setId(idGenerado)
                .setPacienteId(pacienteId)
                .setOptometristaId(optometristaId)
                .setFechaHora(fechaHora)
                .setMotivo(motivo)
                .setEstado(CitaOptometrica.PENDIENTE)
                .build();
    }

    @Deprecated
    public static CitaOptometrica crearCita(
            String tipo,
            String pacienteId,
            String optometristaId,
            LocalDateTime fechaHora
    ) {
        return crearCitaOptometrica(
                tipo,
                pacienteId,
                optometristaId,
                fechaHora
        );
    }
}
