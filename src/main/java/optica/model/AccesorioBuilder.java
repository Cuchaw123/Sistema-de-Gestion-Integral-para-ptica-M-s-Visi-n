package main.java.optica.model;

public class AccesorioBuilder {
    private String id;
    private String nombre;
    private double precio;

    public AccesorioBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public AccesorioBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public AccesorioBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public Accesorio build() {

        return new Accesorio(id, nombre, precio);
    }
}