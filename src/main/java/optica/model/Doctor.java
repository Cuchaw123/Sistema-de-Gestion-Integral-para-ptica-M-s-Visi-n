package main.java.optica.model;


public class Doctor {

    private String id;
    private String nombre;
    private String apellido;
    private String especialidad;     // Ej: "Optometría", "Oftalmología Pediatrica"
    private String nroColegiatura;   // Registro del colegio médico o tecnólogo
    private boolean disponible;      // Para controlar si puede recibir citas

    // Constructor completo (será invocado por el DoctorBuilder)
    public Doctor(String id, String nombre, String apellido, String especialidad, String nroColegiatura, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.nroColegiatura = nroColegiatura;
        this.disponible = disponible;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getNroColegiatura() { return nroColegiatura; }
    public void setNroColegiatura(String nroColegiatura) { this.nroColegiatura = nroColegiatura; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        String estado = disponible ? "DISPONIBLE" : "NO DISPONIBLE";
        return "Doctor [" + id + "] : Dr(a). " + nombre + " " + apellido +
                " | Especialidad: " + especialidad + " | COP/CMP: " + nroColegiatura + " | Estado: " + estado;
    }
}