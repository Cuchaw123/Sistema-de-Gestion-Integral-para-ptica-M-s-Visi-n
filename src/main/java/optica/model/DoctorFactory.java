package main.java.optica.model;

import java.util.UUID;


public class DoctorFactory {


    public static Doctor crearDoctor(String tipo, String nombre, String apellido, String colegiatura) {

        // Generamos un identificador único corto para el empleado
        String idGenerado = "DOC-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();

        if (tipo.equalsIgnoreCase("OPTOMETRA")) {
            return new DoctorBuilder()
                    .setId(idGenerado)
                    .setNombre(nombre)
                    .setApellido(apellido)
                    .setEspecialidad("Optometría General y Contactología")
                    .setNroColegiatura(colegiatura)
                    .setDisponible(true)
                    .build();

        } else if (tipo.equalsIgnoreCase("OFTALMOLOGO")) {
            return new DoctorBuilder()
                    .setId(idGenerado)
                    .setNombre(nombre)
                    .setApellido(apellido)
                    .setEspecialidad("Oftalmología y Cirugía Refractiva")
                    .setNroColegiatura(colegiatura)
                    .setDisponible(true)
                    .build();
        }

        // Opción general por defecto
        return new DoctorBuilder()
                .setId(idGenerado)
                .setNombre(nombre)
                .setApellido(apellido)
                .setEspecialidad("Especialista Visual General")
                .setNroColegiatura(colegiatura)
                .setDisponible(true)
                .build();
    }
}