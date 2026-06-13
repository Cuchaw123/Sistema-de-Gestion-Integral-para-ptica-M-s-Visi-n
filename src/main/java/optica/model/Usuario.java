package main.java.optica.model;


public class Usuario {

    private String id;
    private String nombreCompleto;
    private String username;
    private String password;       // Almacenada de forma segura (Hash)
    private String rolId;          // Enlace con la entidad Rol (ADMINISTRADOR, CAJERO, etc.)
    private String sedeId;         // Enlace con la entidad Sede (Sede física donde labora)
    private boolean activo;        // true = Permite loguearse, false = Acceso revocado

    // Constructor completo (será invocado por el UsuarioBuilder)
    public Usuario(String id, String nombreCompleto, String username, String password, String rolId, String sedeId, boolean activo) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.password = password;
        this.rolId = rolId;
        this.sedeId = sedeId;
        this.activo = activo;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRolId() { return rolId; }
    public void setRolId(String rolId) { this.rolId = rolId; }

    public String getSedeId() { return sedeId; }
    public void setSedeId(String sedeId) { this.sedeId = sedeId; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return "Usuario [" + id + "] " + nombreCompleto + " (@" + username + ")" +
                "\n  Rol ID: " + rolId + " | Sede ID: " + sedeId + " | Acceso: " + (activo ? "Habilitado" : "Bloqueado");
    }
}