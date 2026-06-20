package main.java.optica.model;

import java.time.LocalDate;
import java.time.Period;

public class Paciente {

    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String correo;

    // Constructor completo utilizado por PacienteBuilder
    public Paciente(
            String id,
            String nombre,
            String apellido,
            String dni,
            LocalDate fechaNacimiento,
            String telefono,
            String correo
    ) {
        setId(id);
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
        setFechaNacimiento(fechaNacimiento);
        setTelefono(telefono);
        setCorreo(correo);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    "El identificador del paciente es obligatorio."
            );
        }

        this.id = id.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarTextoPersona(nombre, "nombre");
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        validarTextoPersona(apellido, "apellido");
        this.apellido = apellido.trim();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni == null || !dni.matches("\\d{8}")) {
            throw new IllegalArgumentException(
                    "El DNI debe contener exactamente 8 números."
            );
        }

        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException(
                    "La fecha de nacimiento es obligatoria."
            );
        }

        if (fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "La fecha de nacimiento no puede ser futura."
            );
        }

        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || !telefono.matches("\\d{9}")) {
            throw new IllegalArgumentException(
                    "El teléfono debe contener exactamente 9 números."
            );
        }

        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo == null
                || !correo.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {

            throw new IllegalArgumentException(
                    "El correo electrónico no tiene un formato válido."
            );
        }

        this.correo = correo.trim().toLowerCase();
    }

    // Devuelve el nombre completo del paciente
    public String obtenerNombreCompleto() {
        return nombre + " " + apellido;
    }

    // Calcula la edad usando la fecha actual
    public int calcularEdad() {
        return Period.between(
                fechaNacimiento,
                LocalDate.now()
        ).getYears();
    }

    public boolean esMayorDeEdad() {
        return calcularEdad() >= 18;
    }

    private void validarTextoPersona(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "El " + campo + " es obligatorio."
            );
        }

        if (!valor.matches("[\\p{L} .'-]+")) {
            throw new IllegalArgumentException(
                    "El " + campo + " solo puede contener letras."
            );
        }
    }

    @Override
    public String toString() {
        return "Paciente [" + id + "]"
                + " | Nombre: " + obtenerNombreCompleto()
                + " | DNI: " + dni
                + " | Edad: " + calcularEdad()
                + " | Teléfono: " + telefono
                + " | Correo: " + correo;
    }
}

