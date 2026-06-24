package main.java.optica.model;

/**
 * DTO (Data Transfer Object) del Optometrista.
 * Transporta los datos del optometrista entre capas sin exponer la entidad.
 */
public class OptometristaDTO {

    private String id;
    private String nombre;
    private String apellido;
    private String areaAtencion;
    private String numeroRegistroProfesional;
    private boolean disponible;

    public OptometristaDTO(
            String id,
            String nombre,
            String apellido,
            String areaAtencion,
            String numeroRegistroProfesional,
            boolean disponible
    ) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.areaAtencion = areaAtencion;
        this.numeroRegistroProfesional = numeroRegistroProfesional;
        this.disponible = disponible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setNumeroRegistroProfesional(String numeroRegistroProfesional) {
        this.numeroRegistroProfesional = numeroRegistroProfesional;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}