package main.java.optica.model;


public class UsuarioBuilder {

    private String id;
    private String nombreCompleto;
    private String username;
    private String password;
    private String rolId;
    private String sedeId;
    private boolean activo;

    public UsuarioBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public UsuarioBuilder setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public UsuarioBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UsuarioBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UsuarioBuilder setRolId(String rolId) {
        this.rolId = rolId;
        return this;
    }

    public UsuarioBuilder setSedeId(String sedeId) {
        this.sedeId = sedeId;
        return this;
    }

    public UsuarioBuilder setActivo(boolean activo) {
        this.activo = activo;
        return this;
    }


    public Usuario build() {
        return new Usuario(id, nombreCompleto, username, password, rolId, sedeId, activo);
    }
}