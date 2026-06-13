package main.java.optica.model;


public class RolResponse {

    private String id;
    private String nombreRol;
    private String detallePermisos;
    private String estadoVisual;
    private String mensaje;

    // Constructor vacío obligatorio
    public RolResponse() {
    }

    // Constructor completo
    public RolResponse(String id, String nombreRol, String detallePermisos, String estadoVisual, String mensaje) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.detallePermisos = detallePermisos;
        this.estadoVisual = estadoVisual;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreRol() { return nombreRol; }
    public void setNombreRol(String nombreRol) { this.nombreRol = nombreRol; }

    public String getDetaillePermisos() { return detallePermisos; }
    public void setDetallePermisos(String detallePermisos) { this.detallePermisos = detallePermisos; }

    public String getEstadoVisual() { return estadoVisual; }
    public void setEstadoVisual(String estadoVisual) { this.estadoVisual = estadoVisual; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String toString() {
        return "=======================================\n" +
                "       CONTROL DE ACCESOS Y ROLES      \n" +
                "=======================================\n" +
                " Estado Op:  " + mensaje + "\n" +
                " Código Rol: " + id + "\n" +
                " Perfil:     " + nombreRol + "\n" +
                " Condición:  " + estadoVisual + "\n" +
                "---------------------------------------\n" +
                " Alcance:    " + detallePermisos + "\n" +
                "=======================================\n";
    }
}