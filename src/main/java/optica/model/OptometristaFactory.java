package main.java.optica.model;

import java.util.UUID;

public class OptometristaFactory {

    public static Optometrista crearOptometrista(
            String tipo,
            String nombre,
            String apellido,
            String registroProfesional
    ) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException(
                    "El tipo de optometrista es obligatorio."
            );
        }

        String idGenerado = "OPT-"
                + UUID.randomUUID()
                .toString()
                .substring(0, 5)
                .toUpperCase();

        String areaAtencion;

        switch (tipo.trim().toUpperCase()) {
            case "GENERAL":
            case "OPTOMETRIA_GENERAL":
                areaAtencion = "Optometría general";
                break;

            case "CONTACTOLOGIA":
                areaAtencion = "Contactología";
                break;

            case "BAJA_VISION":
                areaAtencion = "Baja visión";
                break;

            case "OPTOMETRIA_PEDIATRICA":
                areaAtencion = "Optometría pediátrica";
                break;

            default:
                areaAtencion = "Atención optométrica general";
                break;
        }

        return new OptometristaBuilder()
                .setId(idGenerado)
                .setNombre(nombre)
                .setApellido(apellido)
                .setAreaAtencion(areaAtencion)
                .setNumeroRegistroProfesional(registroProfesional)
                .setDisponible(true)
                .build();
    }
}