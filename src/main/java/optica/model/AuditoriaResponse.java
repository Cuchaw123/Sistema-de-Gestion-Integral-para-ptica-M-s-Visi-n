package main.java.optica.model;

import java.time.LocalDateTime;


public class AuditoriaResponse {

    private String id;
    private String usuario;
    private String operacion;
    private String modulo;
    private LocalDateTime fechaHora;
    private String mensajeEstado;

    // Constructor vacío
    public AuditoriaResponse() {
    }

    // Constructor completo
    public AuditoriaResponse(String id, String usuario, String operacion, String modulo, LocalDateTime fechaHora, String mensajeEstado) {
        this.id = id;
        this.usuario = usuario;
        this.operacion = operacion;
        this.modulo = modulo;
        this.fechaHora = fechaHora;
        this.mensajeEstado = mensajeEstado;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getOperacion() { return operacion; }
    public void setOperacion(String operacion) { this.operacion = operacion; }

    public String getModulo() { return modulo; }
    public void setModulo(String modulo) { this.modulo = modulo; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getMensajeEstado() { return mensajeEstado; }
    public void setMensajeEstado(String mensajeEstado) { this.mensajeEstado = mensajeEstado; }

    @Override
    public String toString() {
        return ">>> AUDITORÍA REGISTRADA: " + mensajeEstado + " <<<\n" +
                "ID: " + id + " | Usuario: " + usuario + "\n" +
                "Acción: " + operacion + " en módulo '" + modulo + "'\n" +
                "Fecha/Hora: " + fechaHora;
    }
}