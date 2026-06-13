package main.java.optica.model;

import java.util.UUID;


public class SedeFactory {


    public static Sede crearSedeLocal(String distrito, String direccion) {

        // Generamos un identificador único para el código interno de la sucursal
        String idGenerado = "SDE-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();

        if (distrito.equalsIgnoreCase("MIRAFLORES")) {
            return new SedeBuilder()
                    .setId(idGenerado)
                    .setNombre("Óptica Más Visión - Miraflores")
                    .setDireccion(direccion)
                    .setTelefono("(01) 444-1234")
                    .setActiva(true)
                    .build();

        } else if (distrito.equalsIgnoreCase("SAN ISIDRO")) {
            return new SedeBuilder()
                    .setId(idGenerado)
                    .setNombre("Óptica Más Visión - San Isidro")
                    .setDireccion(direccion)
                    .setTelefono("(01) 222-5678")
                    .setActiva(true)
                    .build();

        } else if (distrito.equalsIgnoreCase("CENTRO")) {
            return new SedeBuilder()
                    .setId(idGenerado)
                    .setNombre("Óptica Más Visión - Centro de Lima")
                    .setDireccion(direccion)
                    .setTelefono("(01) 333-9012")
                    .setActiva(true)
                    .build();
        }

        // Sede estándar provisional por defecto
        return new SedeBuilder()
                .setId(idGenerado)
                .setNombre("Óptica Más Visión - Sucursal " + distrito)
                .setDireccion(direccion)
                .setTelefono("(01) 700-0000")
                .setActiva(true)
                .build();
    }
}