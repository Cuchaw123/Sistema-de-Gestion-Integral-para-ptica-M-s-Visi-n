package main.java.optica.model;

import java.util.UUID;


public class UsuarioFactory {


    public static Usuario crearUsuarioNuevo(String nombre, String puesto, String idSede) {

        // Generamos un ID correlativo único de colaborador
        String idGenerado = "USR-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();

        // Creamos un nombre de usuario básico en minúsculas a partir del primer nombre
        String primerNombre = nombre.split(" ")[0].toLowerCase();
        String usernameProvisional = primerNombre + idGenerado.substring(4);

        // Clave temporal estándar: Cambiame2026! (Deberá ser hasheada en el Service)
        String passwordProvisional = "Cambiame2026!";

        if (puesto.equalsIgnoreCase("ADMIN")) {
            return new UsuarioBuilder()
                    .setId(idGenerado)
                    .setNombreCompleto(nombre)
                    .setUsername(usernameProvisional)
                    .setPassword(passwordProvisional)
                    .setRolId("ROL-ADMIN")
                    .setSedeId(idSede)
                    .setActivo(true)
                    .build();

        } else if (puesto.equalsIgnoreCase("CAJERO")) {
            return new UsuarioBuilder()
                    .setId(idGenerado)
                    .setNombreCompleto(nombre)
                    .setUsername(usernameProvisional)
                    .setPassword(passwordProvisional)
                    .setRolId("ROL-CAJERO")
                    .setSedeId(idSede)
                    .setActivo(true)
                    .build();

        } else if (puesto.equalsIgnoreCase("MEDICO")) {
            return new UsuarioBuilder()
                    .setId(idGenerado)
                    .setNombreCompleto(nombre)
                    .setUsername(usernameProvisional)
                    .setPassword(passwordProvisional)
                    .setRolId("ROL-MEDICO")
                    .setSedeId(idSede)
                    .setActivo(true)
                    .build();
        }

        // Colaborador estándar por defecto
        return new UsuarioBuilder()
                .setId(idGenerado)
                .setNombreCompleto(nombre)
                .setUsername(usernameProvisional)
                .setPassword(passwordProvisional)
                .setRolId("ROL-CONSULTOR")
                .setSedeId(idSede)
                .setActivo(true)
                .build();
    }
}