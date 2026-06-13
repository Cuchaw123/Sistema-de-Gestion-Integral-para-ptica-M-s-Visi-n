package main.java.optica.model;


public class AuditoriaRequest {

    private String usuario;
    private String operacion;
    private String modulo;

    // Constructor vacío
    public AuditoriaRequest() {
    }

    // Constructor con parámetros
    public AuditoriaRequest(String usuario, String operacion, String modulo) {
        this.usuario = usuario;
        this.operacion = operacion;
        this.modulo = modulo;
    }

    // Getters y Setters
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
}