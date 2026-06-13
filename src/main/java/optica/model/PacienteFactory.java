package main.java.optica.model;

import java.time.LocalDate;
import java.util.UUID;


public class PacienteFactory {


    public static Paciente crearPacienteEstandar(String nombre, String apellido, String dni, String telefono) {

        // Generamos un código único para la historia clínica física/digital
        String idGenerado = "PAC-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();

        return new PacienteBuilder()
                .setId(idGenerado)
                .setNombre(nombre)
                .setApellido(apellido)
                .setDni(dni)
                .setFechaNacimiento(LocalDate.of(2000, 1, 1)) // Fecha por defecto para completar en auditoría
                .setTelefono(telefono)
                .setCorreo("contacto@optica.com") // Correo provisional del sistema
                .build();
    }
}