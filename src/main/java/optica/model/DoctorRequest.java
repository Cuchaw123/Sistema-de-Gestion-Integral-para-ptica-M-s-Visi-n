package main.java.optica.model;


public class DoctorRequest {

    private String nombre;
    private String apellido;
    private String specialty; // Mapeado como especialidad en la entidad
    private String nroColegiatura;
    private boolean disponible;

    // Constructor vacío
    public DoctorRequest() {
    }

    // Constructor completo
    public DoctorRequest(String nombre, String apellido, String specialty, String nroColegiatura, boolean disponible) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.specialty = specialty;
        this.nroColegiatura = nroColegiatura;
        this.disponible = disponible;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public String getNroColegiatura() { return nroColegiatura; }
    public void setNroColegiatura(String nroColegiatura) { this.nroColegiatura = nroColegiatura; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}