package main.java.optica.model;


public class AuditoriaBuilder {

    private String id;
    private String usuario;
    private String operacion;
    private String modulo;

    public AuditoriaBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public AuditoriaBuilder setUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public AuditoriaBuilder setOperacion(String operacion) {
        this.operacion = operacion;
        return this;
    }

    public AuditoriaBuilder setModulo(String modulo) {
        this.modulo = modulo;
        return this;
    }


    public Auditoria build() {
        return new Auditoria(id, usuario, operacion, modulo);
    }
}