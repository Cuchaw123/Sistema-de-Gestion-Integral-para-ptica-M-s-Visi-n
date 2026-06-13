package main.java.optica.model;


public class SedeResponse {

    private String id;
    private String nombreSede;
    private String direccionCompleta;
    private String contactoTelefono;
    private String mensaje;

    // Constructor vacío obligatorio
    public SedeResponse() {
    }

    // Constructor completo
    public SedeResponse(String id, String nombreSede, String direccionCompleta, String contactoTelefono, String mensaje) {
        this.id = id;
        this.nombreSede = nombreSede;
        this.direccionCompleta = direccionCompleta;
        this.contactoTelefono = contactoTelefono;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreSede() { return nombreSede; }
    public void setNombreSede(String nombreSede) { this.nombreSede = nombreSede; }

    public String getDireccionCompleta() { return direccionCompleta; }
    public void setDireccionCompleta(String direccionCompleta) { this.direccionCompleta = direccionCompleta; }

    public String getContactoTelefono() { return contactoTelefono; }
    public void setContactoTelefono(String contactoTelefono) { this.contactoTelefono = contactoTelefono; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String toString() {
        return "=======================================\n" +
                "         REGISTRO DE SEDE / TIENDA     \n" +
                "=======================================\n" +
                " Operación:  " + mensaje + "\n" +
                " Código:     " + id + "\n" +
                " Establec:   " + nombreSede + "\n" +
                "---------------------------------------\n" +
                " Dirección:  " + direccionCompleta + "\n" +
                " Teléfono:   " + contactoTelefono + "\n" +
                "=======================================\n";
    }
}