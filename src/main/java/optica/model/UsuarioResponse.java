package main.java.optica.model;


public class UsuarioResponse {

    private String id;
    private String cuentaUsername;
    private String nombreEmpleado;
    private String estadoAcceso;
    private String mensajeResultado;

    // Constructor vacío obligatorio
    public UsuarioResponse() {
    }

    // Constructor completo
    public UsuarioResponse(String id, String cuentaUsername, String nombreEmpleado, String estadoAcceso, String mensajeResultado) {
        this.id = id;
        this.cuentaUsername = cuentaUsername;
        this.nombreEmpleado = nombreEmpleado;
        this.estadoAcceso = estadoAcceso;
        this.mensajeResultado = mensajeResultado;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCuentaUsername() { return cuentaUsername; }
    public void setCuentaUsername(String cuentaUsername) { this.cuentaUsername = cuentaUsername; }

    public String getNombreEmpleado() { return nombreEmpleado; }
    public void setNombreEmpleado(String nombreEmpleado) { this.nombreEmpleado = nombreEmpleado; }

    public String getEstadoAcceso() { return estadoAcceso; }
    public void setEstadoAcceso(String estadoAcceso) { this.estadoAcceso = estadoAcceso; }

    public String getMensajeResultado() { return mensajeResultado; }
    public void setMensajeResultado(String mensajeResultado) { this.mensajeResultado = mensajeResultado; }

    @Override
    public String toString() {
        return "=======================================\n" +
                "       AUTENTICACIÓN Y CREDENCIALES   \n" +
                "=======================================\n" +
                " Resultado:  " + mensajeResultado + "\n" +
                " Código:     " + id + "\n" +
                " Colaborador:" + nombreEmpleado + "\n" +
                " Usuario:    @" + cuentaUsername + "\n" +
                "---------------------------------------\n" +
                " Acceso Sys: " + estadoAcceso + "\n" +
                "=======================================\n";
    }
}