package main.java.optica.model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class AuditoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String usuario;
    private String operacion;
    private String modulo;
    private LocalDateTime fechaHora;

    // Constructor vacío
    public AuditoriaDTO() {
    }

    // Constructor completo
    public AuditoriaDTO(String id, String usuario, String operacion, String modulo, LocalDateTime fechaHora) {
        this.id = id;
        this.usuario = usuario;
        this.operacion = operacion;
        this.modulo = modulo;
        this.fechaHora = fechaHora;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "AuditoriaDTO{" +
                "id='" + id + '\'' +
                ", usuario='" + usuario + '\'' +
                ", operacion='" + operacion + '\'' +
                ", modulo='" + modulo + '\'' +
                ", fechaHora=" + fechaHora +
                '}';
    }
}