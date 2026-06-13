package main.java.optica.model;

import java.time.LocalDateTime;


public class Auditoria {

    // Atributos 'final' para garantizar la inmutabilidad
    private final String id;
    private final String usuario;
    private final String operacion;
    private final String modulo; // Ej: "Expedientes", "Citas", "Facturación"
    private final LocalDateTime fechaHora;


    public Auditoria(String id, String usuario, String operacion, String modulo) {
        this.id = id;
        this.usuario = usuario;
        this.operacion = operacion;
        this.modulo = modulo;
        this.fechaHora = LocalDateTime.now(); // Captura automática del sistema
    }

    // Solo Getters, ningún Setter (Inmutabilidad)

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

    @Override
    public String toString() {
        return String.format("[%s] Módulo: %s | Usuario: %s | Acción: %s",
                fechaHora, modulo, usuario, operacion);
    }
}