package main.java.optica.model;

import java.io.Serializable;


public class DoctorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String nroColegiatura;
    private boolean disponible;

    // Constructor vacío obligatorio
    public DoctorDTO() {
    }

    // Constructor completo
    public DoctorDTO(String id, String nombre, String apellido, String especialidad, String nroColegiatura, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.nroColegiatura = nroColegiatura;
        this.disponible = disponible;
    }

    // Getters y Setters
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNroColegiatura() {
        return nroColegiatura;
    }

    public void setNroColegiatura(String nroColegiatura) {
        this.nroColegiatura = nroColegiatura;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", nroColegiatura='" + nroColegiatura + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}