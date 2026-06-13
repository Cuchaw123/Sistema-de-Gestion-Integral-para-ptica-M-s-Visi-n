package main.java.optica.model;


public class UsuarioRequest {

    private String nombreCompleto;
    private String username;
    private String password;
    private String rolId;
    private String sedeId;

    // Constructor vacío obligatorio
    public UsuarioRequest() {
    }

    // Constructor completo
    public UsuarioRequest(String nombreCompleto, String username, String password, String rolId, String sedeId) {
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.password = password;
        this.rolId = rolId;
        this.sedeId = sedeId;
    }

    // Getters y Setters
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
}