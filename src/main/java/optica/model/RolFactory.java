package main.java.optica.model;

import java.util.UUID;


public class RolFactory {


    public static Rol crearRolPredeterminado(String tipoRol) {

        // Generamos un identificador único para el código de seguridad del rol
        String idGenerado = "ROL-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();

        if (tipoRol.equalsIgnoreCase("ADMIN")) {
            return new RolBuilder()
                    .setId(idGenerado)
                    .setNombre("ADMINISTRADOR")
                    .setDescripcion("Acceso total al sistema: Configuración, auditorías, inventarios y gestión de usuarios.")
                    .setEstado(true)
                    .build();

        } else if (tipoRol.equalsIgnoreCase("CAJERO")) {
            return new RolBuilder()
                    .setId(idGenerado)
                    .setNombre("CAJERO")
                    .setDescripcion("Permisos operativos de punto de venta: Apertura/cierre de caja, facturación y cobros.")
                    .setEstado(true)
                    .build();

        } else if (tipoRol.equalsIgnoreCase("MEDICO")) {
            return new RolBuilder()
                    .setId(idGenerado)
                    .setNombre("OPTOMETRA")
                    .setDescripcion("Permisos asistenciales: Registro de refracciones, consulta de historial clínico y recetas.")
                    .setEstado(true)
                    .build();
        }

        // Rol de soporte básico por defecto
        return new RolBuilder()
                .setId(idGenerado)
                .setNombre("CONSULTOR")
                .setDescripcion("Acceso restringido en modo lectura para consultas rápidas de catálogo.")
                .setEstado(true)
                .build();
    }
}