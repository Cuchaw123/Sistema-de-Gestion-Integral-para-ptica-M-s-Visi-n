package main.java.optica.model;

import java.util.UUID;


public class AuditoriaFactory {


    public static Auditoria crearRegistro(String usuario, String operacion, String modulo) {
        // Genera un ID aleatorio único, ej: AUD-A1B2C3D4
        String idGenerado = "AUD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        // Usamos el Builder que creamos anteriormente
        return new AuditoriaBuilder()
                .setId(idGenerado)
                .setUsuario(usuario)
                .setOperacion(operacion)
                .setModulo(modulo)
                .build();
    }


    public static Auditoria crearAuditoriaAcceso(String usuario, boolean exito) {
        String idGenerado = "LOG-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        String estado = exito ? "Inicio de sesión exitoso" : "Intento de acceso denegado";

        return new Auditoria(idGenerado, usuario, estado, "Seguridad");
    }


    public static Auditoria crearAuditoriaError(String usuario, String detalleError) {
        String idGenerado = "ERR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        return new Auditoria(idGenerado, usuario, "Fallo en operación: " + detalleError, "Sistema");
    }
}