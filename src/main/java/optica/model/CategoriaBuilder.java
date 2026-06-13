package main.java.optica.model;


public class CategoriaBuilder {

    private String id;
    private String nombre;
    private String descripcion;

    public CategoriaBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public CategoriaBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public CategoriaBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }


    public Categoria build() {
        return new Categoria(id, nombre, descripcion);
    }
}