package main.java.optica.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Factory para crear historiales ópticos preconfigurados.
 * Aplica el patrón Factory Method.
 */
public class HistorialOpticoFactory {

    /**
     * Crea un historial óptico según una plantilla visual.
     *
     * @param plantilla tipo de examen: LECTURA, PROMEDIO o EMETROPE
     * @param pacienteId ID del paciente
     * @param optometristaId ID del optometrista
     * @return historial óptico configurado
     */
    public static HistorialOptico crearHistorialOptico(
            String plantilla,
            String pacienteId,
            String optometristaId
    ) {
        String idGenerado = "HIS-"
                + UUID.randomUUID()
                .toString()
                .substring(0, 6)
                .toUpperCase();

        String tipoPlantilla = plantilla == null
                ? "EMETROPE"
                : plantilla.trim().toUpperCase();

        switch (tipoPlantilla) {

            case "LECTURA":
                return new HistorialOpticoBuilder()
                        .setId(idGenerado)
                        .setPacienteId(pacienteId)
                        .setOptometristaId(optometristaId)
                        .setFechaExamen(LocalDateTime.now())
                        .setDiagnostico("Presbicia o vista cansada")
                        .setObservaciones(
                                "Se recomiendan lunas para lectura o visión cercana."
                        )
                        .setOdEsfera(0.0)
                        .setOdCilindro(0.0)
                        .setOdEje(0)
                        .setOdAdicion(2.00)
                        .setOiEsfera(0.0)
                        .setOiCilindro(0.0)
                        .setOiEje(0)
                        .setOiAdicion(2.00)
                        .build();

            case "PROMEDIO":
                return new HistorialOpticoBuilder()
                        .setId(idGenerado)
                        .setPacienteId(pacienteId)
                        .setOptometristaId(optometristaId)
                        .setFechaExamen(LocalDateTime.now())
                        .setDiagnostico("Miopía simple leve")
                        .setObservaciones(
                                "Se recomienda el uso de lentes para visión lejana y pantallas."
                        )
                        .setOdEsfera(-1.50)
                        .setOdCilindro(0.0)
                        .setOdEje(0)
                        .setOdAdicion(0.0)
                        .setOiEsfera(-1.25)
                        .setOiCilindro(0.0)
                        .setOiEje(0)
                        .setOiAdicion(0.0)
                        .build();

            case "EMETROPE":
            default:
                return new HistorialOpticoBuilder()
                        .setId(idGenerado)
                        .setPacienteId(pacienteId)
                        .setOptometristaId(optometristaId)
                        .setFechaExamen(LocalDateTime.now())
                        .setDiagnostico("Emetropía o visión normal")
                        .setObservaciones(
                                "No presenta errores refractivos. Se puede recomendar filtro de protección."
                        )
                        .setOdEsfera(0.0)
                        .setOdCilindro(0.0)
                        .setOdEje(0)
                        .setOdAdicion(0.0)
                        .setOiEsfera(0.0)
                        .setOiCilindro(0.0)
                        .setOiEje(0)
                        .setOiAdicion(0.0)
                        .build();
        }
    }

    /**
     * Método temporal para evitar errores en clases antiguas.
     */
    @Deprecated
    public static HistorialOptico crearHistorial(
            String plantilla,
            String pacienteId,
            String doctorId
    ) {
        return crearHistorialOptico(
                plantilla,
                pacienteId,
                doctorId
        );
    }
}
