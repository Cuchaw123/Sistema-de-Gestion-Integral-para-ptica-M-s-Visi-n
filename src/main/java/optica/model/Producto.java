package main.java.optica.model;


public class Producto {

    private String id;
    private String nombre;        // Ej: "Líquido Limpiador Anti-fog", "Estuche Rígido"
    private String categoria;     // Ej: "Limpieza", "Accesorios", "Salud Visual"
    private String descripcion;   // Ej: "Spray de 60ml para lunas con tratamiento antireflex"
    private double precio;
    private int stock;

    // Constructor completo (será invocado por el ProductoBuilder)
    public Producto(String id, String nombre, String categoria, String descripcion, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

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

    @Override
    public String toString() {
        return "Producto [" + id + "] " + nombre + " (" + categoria + ")" +
                "\n  Detalle: " + descripcion +
                "\n  Precio: S/. " + precio + " | Stock: " + stock + " und.";
    }
}