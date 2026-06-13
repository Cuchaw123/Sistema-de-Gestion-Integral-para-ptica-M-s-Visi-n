package main.java.optica.model;

import java.time.LocalDateTime;
import java.util.UUID;


public class CitaFactory {


    public static Cita crearCita(String tipo, String pacienteId, String doctorId, LocalDateTime fechaHora) {

        // Autogeneramos un ID corto para la cita
        String idGenerado = "CIT-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        if (tipo.equalsIgnoreCase("CONTROL")) {
            return new CitaBuilder()
                    .setId(idGenerado)
                    .setPacienteId(pacienteId)
                    .setDoctorId(doctorId)
                    .setFechaHora(fechaHora)
                    .setMotivo("Control de medida de vista")
                    .setEstado("PENDIENTE")
                    .build();

        } else if (tipo.equalsIgnoreCase("ENTREGA")) {
            return new CitaBuilder()
                    .setId(idGenerado)
                    .setPacienteId(pacienteId)
                    .setDoctorId(doctorId)
                    .setFechaHora(fechaHora)
                    .setMotivo("Entrega y ajuste de montura")
                    .setEstado("PENDIENTE")
                    .build();
        }

     // Examen general para un paciente nuevo
        return new CitaBuilder()
                .setId(idGenerado)
                .setPacienteId(pacienteId)
                .setDoctorId(doctorId)
                .setFechaHora(fechaHora)
                .setMotivo("Examen optométrico completo")
                .setEstado("PENDIENTE")
                .build();
    }
}