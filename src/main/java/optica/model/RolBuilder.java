package main.java.optica.model;


public class RolBuilder {

    private String id;
    private String nombre;
    private String descripcion;
    private boolean estado;

    public RolBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public RolBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public RolBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public RolBuilder setEstado(boolean estado) {
        this.estado = estado;
        return this;
    }


    public Rol build() {
        return new Rol(id, nombre, descripcion, estado);
    }
}