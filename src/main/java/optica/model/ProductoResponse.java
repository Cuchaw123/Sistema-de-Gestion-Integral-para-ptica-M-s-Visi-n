package main.java.optica.model;


public class ProductoResponse {

    private String id;
    private String nombre;
    private String categoria;
    private double precioVenta;
    private int stockActual;
    private String mensaje;

    // Constructor vacío
    public ProductoResponse() {
    }

    // Constructor completo
    public ProductoResponse(String id, String nombre, String categoria, double precioVenta, int stockActual, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioVenta = precioVenta;
        this.stockActual = stockActual;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public double getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }

    public int getStockActual() { return stockActual; }
    public void setStockActual(int stockActual) { this.stockActual = stockActual; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String toString() {
        return "=== INVENTARIO DE ACCESORIOS ===\n" +
                " Operación: " + mensaje + "\n" +
                " SKU:       " + id + "\n" +
                " Nombre:    " + nombre + " [" + categoria + "]\n" +
                " Precio:    S/. " + String.format("%.2f", precioVenta) + " | Stock: " + stockActual + " und.\n" +
                "=================================";
    }
}