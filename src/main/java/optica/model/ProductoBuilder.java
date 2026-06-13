package main.java.optica.model;


public class ProductoBuilder {

    private String id;
    private String nombre;
    private String categoria;
    private String descripcion;
    private double precio;
    private int stock;

    public ProductoBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ProductoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoBuilder setCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public ProductoBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ProductoBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoBuilder setStock(int stock) {
        this.stock = stock;
        return this;
    }

    /**
     * Construye la instancia definitiva de Producto con los valores asignados.
     * @return Una nueva instancia de Producto.
     */
    public Producto build() {
        return new Producto(id, nombre, categoria, descripcion, precio, stock);
    }
}