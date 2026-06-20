package main.java.optica.model;

public class OptometristaBuilder {

    private String id;
    private String nombre;
    private String apellido;
    private String areaAtencion;
    private String numeroRegistroProfesional;
    private boolean disponible;

    public OptometristaBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public OptometristaBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public OptometristaBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public OptometristaBuilder setAreaAtencion(String areaAtencion) {
        this.areaAtencion = areaAtencion;
        return this;
    }

    public OptometristaBuilder setNumeroRegistroProfesional(
            String numeroRegistroProfesional
    ) {
        this.numeroRegistroProfesional = numeroRegistroProfesional;
        return this;
    }

    public OptometristaBuilder setDisponible(boolean disponible) {
        this.disponible = disponible;
        return this;
    }

    public Optometrista build() {
        return new Optometrista(
                id,
                nombre,
                apellido,
                areaAtencion,
                numeroRegistroProfesional,
                disponible
        );
    }
}
