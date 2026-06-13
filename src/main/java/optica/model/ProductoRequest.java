package main.java.optica.model;


public class ProductoRequest {

    private String nombre;
    private String categoria;
    private String descripcion;
    private double precio;
    private int stock;

    // Constructor vacío
    public ProductoRequest() {
    }

    // Constructor completo
    public ProductoRequest(String nombre, String categoria, String descripcion, double precio, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}