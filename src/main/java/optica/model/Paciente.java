package main.java.optica.model;

import java.time.LocalDate;


public class Paciente {

    private String id;
    private String nombre;
    private String apellido;
    private String dni;            // Documento Nacional de Identidad
    private LocalDate fechaNacimiento;
    private String telefono;
    private String correo;

    // Constructor completo (será invocado por el PacienteBuilder)
    public Paciente(String id, String nombre, String apellido, String dni, LocalDate fechaNacimiento, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    @Override
    public String toString() {
        return "Paciente [" + id + "] : " + nombre + " " + apellido +
                " | DNI: " + dni + " | Tel: " + telefono + " | Email: " + correo;
    }
}