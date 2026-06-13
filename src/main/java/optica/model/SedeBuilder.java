package main.java.optica.model;


public class SedeBuilder {

    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private boolean activa;

    public SedeBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public SedeBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public SedeBuilder setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public SedeBuilder setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public SedeBuilder setActiva(boolean activa) {
        this.activa = activa;
        return this;
    }


    public Sede build() {
        return new Sede(id, nombre, direccion, telefono, activa);
    }
}