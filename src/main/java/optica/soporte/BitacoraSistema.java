package main.java.optica.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auditoria {

    private final String id;
    private final String usuario;
    private final String operacion;

    // Ej.: "Pacientes", "Recetas", "Inventario",
    // "Pedidos", "Ventas", "Pagos"
    private final String modulo;

    private final LocalDateTime fechaHora;

    public Auditoria(
            String id,
            String usuario,
            String operacion,
            String modulo
    ) {
        this.id = validarTexto(id, "identificador");
        this.usuario = validarTexto(usuario, "usuario");
        this.operacion = validarTexto(operacion, "operación");
        this.modulo = validarTexto(modulo, "módulo");
        this.fechaHora = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getOperacion() {
        return operacion;
    }

    public String getModulo() {
        return modulo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public boolean perteneceAlModulo(String moduloBuscado) {
        if (moduloBuscado == null || moduloBuscado.isBlank()) {
            return false;
        }

        return modulo.equalsIgnoreCase(moduloBuscado.trim());
    }

    public boolean fueRealizadaPor(String usuarioBuscado) {
        if (usuarioBuscado == null || usuarioBuscado.isBlank()) {
            return false;
        }

        return usuario.equalsIgnoreCase(usuarioBuscado.trim());
    }

    public String obtenerFechaHoraFormateada() {
        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return fechaHora.format(formato);
    }

    private String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " es obligatorio."
            );
        }

        return valor.trim();
    }

    @Override
    public String toString() {
        return "[" + obtenerFechaHoraFormateada() + "]"
                + " | Módulo: " + modulo
                + " | Usuario: " + usuario
                + " | Acción: " + operacion;
    }
}

