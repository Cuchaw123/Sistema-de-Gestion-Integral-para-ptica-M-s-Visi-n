package main.java.optica.model;


public class DoctorBuilder {

    private String id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String nroColegiatura;
    private boolean disponible;

    public DoctorBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public DoctorBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DoctorBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public DoctorBuilder setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
        return this;
    }

    public DoctorBuilder setNroColegiatura(String nroColegiatura) {
        this.nroColegiatura = nroColegiatura;
        return this;
    }

    public DoctorBuilder setDisponible(boolean disponible) {
        this.disponible = disponible;
        return this;
    }


    public Doctor build() {
        return new Doctor(id, nombre, apellido, especialidad, nroColegiatura, disponible);
    }
}