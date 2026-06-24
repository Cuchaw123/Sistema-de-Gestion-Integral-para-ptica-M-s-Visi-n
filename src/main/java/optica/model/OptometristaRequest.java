package main.java.optica.model;

public class OptometristaRequest {

    private String nombre;
    private String apellido;
    private String areaAtencion;
    private String numeroRegistroProfesional;
    private boolean disponible;

    public OptometristaRequest() {
    }

    public OptometristaRequest(
            String nombre,
            String apellido,
            String areaAtencion,
            String numeroRegistroProfesional,
            boolean disponible
    ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.areaAtencion = areaAtencion;
        this.numeroRegistroProfesional = numeroRegistroProfesional;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAreaAtencion() {
        return areaAtencion;
    }

    public void setAreaAtencion(String areaAtencion) {
        this.areaAtencion = areaAtencion;
    }

    public String getNumeroRegistroProfesional() {
        return numeroRegistroProfesional;
    }

    public void setNumeroRegistroProfesional(
            String numeroRegistroProfesional
    ) {
        this.numeroRegistroProfesional = numeroRegistroProfesional;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /*
     * Métodos temporales para evitar errores
     * mientras otras clases usan los nombres antiguos.
     */
    @Deprecated
    public String getSpecialty() {
        return areaAtencion;
    }

    @Deprecated
    public void setSpecialty(String specialty) {
        this.areaAtencion = specialty;
    }

    @Deprecated
    public String getNroColegiatura() {
        return numeroRegistroProfesional;
    }

    @Deprecated
    public void setNroColegiatura(String nroColegiatura) {
        this.numeroRegistroProfesional = nroColegiatura;
    }

    @Override
    public String toString() {
        return "OptometristaRequest{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", areaAtencion='" + areaAtencion + '\'' +
                ", numeroRegistroProfesional='" +
                numeroRegistroProfesional + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
