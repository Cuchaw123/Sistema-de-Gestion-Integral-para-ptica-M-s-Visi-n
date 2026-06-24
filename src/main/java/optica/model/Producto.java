package main.java.optica.model;

public class Producto {

    private String id;
    private String nombre;
    private String categoria;
    private String descripcion;
    private double precio;
    private int stock;

    // Constructor completo utilizado por ProductoBuilder
    public Producto(
            String id,
            String nombre,
            String categoria,
            String descripcion,
            double precio,
            int stock
    ) {
        setId(id);
        setNombre(nombre);
        setCategoria(categoria);
        setDescripcion(descripcion);
        setPrecio(precio);
        setStock(stock);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    "El identificador del producto es obligatorio."
            );
        }

        this.id = id.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre del producto es obligatorio."
            );
        }

        this.nombre = nombre.trim();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException(
                    "La categoría del producto es obligatoria."
            );
        }

        this.categoria = categoria.trim();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException(
                    "La descripción del producto es obligatoria."
            );
        }

        this.descripcion = descripcion.trim();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (Double.isNaN(precio) || Double.isInfinite(precio)) {
            throw new IllegalArgumentException(
                    "El precio debe ser un número válido."
            );
        }

        if (precio < 0) {
            throw new IllegalArgumentException(
                    "El precio del producto no puede ser negativo."
            );
        }

        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException(
                    "El stock del producto no puede ser negativo."
            );
        }

        this.stock = stock;
    }

    // Comprueba si existe al menos una unidad disponible
    public boolean hayStock() {
        return stock > 0;
    }

    // Comprueba si existe la cantidad solicitada
    public boolean hayStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad consultada debe ser mayor que cero."
            );
        }

        return stock >= cantidad;
    }

    // Agrega unidades al inventario
    public void aumentarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad que se agregará debe ser mayor que cero."
            );
        }

        stock += cantidad;
    }

    // Retira unidades cuando se realiza una venta
    public void disminuirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad que se retirará debe ser mayor que cero."
            );
        }

        if (!hayStock(cantidad)) {
            throw new IllegalStateException(
                    "Stock insuficiente. Disponible: " + stock
                            + ", solicitado: " + cantidad + "."
            );
        }

        stock -= cantidad;
    }

    // Permite identificar productos próximos a agotarse
    public boolean tieneStockBajo(int limite) {
        if (limite < 0) {
            throw new IllegalArgumentException(
                    "El límite de stock no puede ser negativo."
            );
        }

        return stock <= limite;
    }

    // Calcula cuánto vale todo el stock disponible del producto
    public double calcularValorInventario() {
        return precio * stock;
    }

    @Override
    public String toString() {
        return "Producto [" + id + "]"
                + " | Nombre: " + nombre
                + " | Categoría: " + categoria
                + "\n  Descripción: " + descripcion
                + "\n  Precio: S/ " + String.format("%.2f", precio)
                + " | Stock: " + stock + " unidades";
    }
}
