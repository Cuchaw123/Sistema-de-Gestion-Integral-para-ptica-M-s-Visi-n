package main.java.optica.model;

import java.time.LocalTime;
import java.util.UUID;


public class TurnoFactory {


    public static Turno crearTurnoEstandar(String tipoTurno) {

        // Generamos un identificador único para el código de control del turno
        String idGenerado = "TRN-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();

        if (tipoTurno.equalsIgnoreCase("MANANA")) {
            return new TurnoBuilder()
                    .setId(idGenerado)
                    .setNombre("Turno Mañana")
                    .setHoraInicio(LocalTime.of(9, 0))  // 09:00 AM
                    .setHoraFin(LocalTime.of(13, 0))   // 01:00 PM
                    .setActivo(true)
                    .build();

        } else if (tipoTurno.equalsIgnoreCase("TARDE")) {
            return new TurnoBuilder()
                    .setId(idGenerado)
                    .setNombre("Turno Tarde")
                    .setHoraInicio(LocalTime.of(14, 0)) // 02:00 PM
                    .setHoraFin(LocalTime.of(20, 0))  // 08:00 PM
                    .setActivo(true)
                    .build();

        } else if (tipoTurno.equalsIgnoreCase("COMPLETO")) {
            return new TurnoBuilder()
                    .setId(idGenerado)
                    .setNombre("Jornada Completa")
                    .setHoraInicio(LocalTime.of(9, 0))  // 09:00 AM
                    .setHoraFin(LocalTime.of(18, 0))   // 06:00 PM
                    .setActivo(true)
                    .build();
        }

        // Horario por defecto (Bloque de guardia o apoyo)
        return new TurnoBuilder()
                .setId(idGenerado)
                .setNombre("Bloque Flexible")
                .setHoraInicio(LocalTime.of(10, 0))
                .setHoraFin(LocalTime.of(16, 0))
                .setActivo(true)
                .build();
    }
}