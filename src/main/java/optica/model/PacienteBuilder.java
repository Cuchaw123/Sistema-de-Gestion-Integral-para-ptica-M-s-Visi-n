package main.java.optica.model;

import java.time.LocalDate;


public class PacienteBuilder {

    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String correo;

    public PacienteBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public PacienteBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PacienteBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public PacienteBuilder setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public PacienteBuilder setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public PacienteBuilder setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public PacienteBuilder setCorreo(String correo) {
        this.correo = correo;
        return this;
    }


    public Paciente build() {
        return new Paciente(id, nombre, apellido, dni, fechaNacimiento, telefono, correo);
    }
}