package main.java.optica.model;


public class PacienteResponse {

    private String id;
    private String nombreCompleto;
    private String dni;
    private String contacto; // Ej: "Tel: 987654321 | email@test.com"
    private String mensaje;

    // Constructor vacío
    public PacienteResponse() {
    }

    // Constructor completo
    public PacienteResponse(String id, String nombreCompleto, String dni, String contacto, String mensaje) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.contacto = contacto;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String toString() {
        return "=== HISTORIA CLÍNICA: APERTURA ===\n" +
                " Resultado: " + mensaje + "\n" +
                " Código PAC: " + id + "\n" +
                " Paciente:   " + nombreCompleto + " (DNI: " + dni + ")\n" +
                " Contacto:   " + contacto + "\n" +
                "====================================";
    }
}