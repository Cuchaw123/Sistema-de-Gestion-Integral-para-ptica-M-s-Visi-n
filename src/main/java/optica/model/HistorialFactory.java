package main.java.optica.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Factory para la creación automatizada de Historiales Clínicos y recetas visuales.
 * Aplica el patrón Factory Method.
 */
public class HistorialFactory {

    /**
     * Crea un Historial Clínico preconfigurado según la condición o plantilla visual del examen.
     * @param plantilla Tipo de examen ("LECTURA", "EMETROPE", "PROMEDIO")
     * @param pacienteId ID del paciente examinado
     * @param doctorId ID del doctor u optómetra que realiza la prueba
     * @return Instancia de Historial configurada.
     */
    public static Historial crearHistorial(String plantilla, String pacienteId, String doctorId) {

        // Generamos un código único para la receta médica
        String idGenerado = "REC-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        if (plantilla.equalsIgnoreCase("LECTURA")) {
            // Plantilla típica para presbicia (vista cansada, requiere adición)
            return new HistorialBuilder()
                    .setId(idGenerado)
                    .setPacienteId(pacienteId)
                    .setDoctorId(doctorId)
                    .setFechaExamen(LocalDateTime.now())
                    .setDiagnostico("Presbicia senil / Vista cansada")
                    .setObservaciones("Lunas recomendadas exclusivamente para lectura o visión cercana.")
                    .setOdEsfera(0.0).setOdCilindro(0.0).setOdEje(0).setOdAdicion(2.00) // Adición +2.00 OD
                    .setOiEsfera(0.0).setOiCilindro(0.0).setOiEje(0).setOiAdicion(2.00) // Adición +2.00 OI
                    .build();

        } else if (plantilla.equalsIgnoreCase("PROMEDIO")) {
            // Plantilla con una miopía leve estándar
            return new HistorialBuilder()
                    .setId(idGenerado)
                    .setPacienteId(pacienteId)
                    .setDoctorId(doctorId)
                    .setFechaExamen(LocalDateTime.now())
                    .setDiagnostico("Miopía simple leve")
                    .setObservaciones("Uso de lentes de forma permanente para actividades externas y pantallas.")
                    .setOdEsfera(-1.50).setOdCilindro(0.0).setOdEje(0).setOdAdicion(0.0)
                    .setOiEsfera(-1.25).setOiCilindro(0.0).setOiEje(0).setOiAdicion(0.0)
                    .build();
        }

        // Por defecto: Plantilla Emétrope (Paciente con vista perfecta 20/20, examen de control)
        return new HistorialBuilder()
                .setId(idGenerado)
                .setPacienteId(pacienteId)
                .setDoctorId(doctorId)
                .setFechaExamen(LocalDateTime.now())
                .setDiagnostico("Emétrope - Visión Normal / Filtro de protección")
                .setObservaciones("No presenta vicios de refracción. Se sugieren lunas con filtro Blue Defense.")
                .setOdEsfera(0.0).setOdCilindro(0.0).setOdEje(0).setOdAdicion(0.0)
                .setOiEsfera(0.0).setOiCilindro(0.0).setOiEje(0).setOiAdicion(0.0)
                .build();
    }
}