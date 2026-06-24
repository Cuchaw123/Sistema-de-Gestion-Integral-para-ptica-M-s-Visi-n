package main.java.optica.model;

/**
 * Entidad que representa una montura o armazón
 * disponible en la Óptica Más Visión.
 */
public class Montura {

    private String id;

    // Marca o fabricante. Ej.: "Ray-Ban", "Oakley", "Vogue"
    private String marca;

    // Código o nombre comercial. Ej.: "Aviator RB3025"
    private String modelo;

    // Material principal. Ej.: "Acetato", "Titanio"
    private String material;

    // Tipo de estructura. Ej.: "Aro completo", "Semi al aire", "Al aire"
    private String tipoAro;

    // Forma de la montura. Ej.: "Rectangular", "Aviador", "Ojo de gato"
    private String forma;

    private String color;
    private double precio;
    private int stock;


    public Montura(
            String id,
            String marca,
            String modelo,
            String material,
            String tipoAro,
            String forma,
            String color,
            double precio,
            int stock
    ) {
        setId(id);
        setMarca(marca);
        setModelo(modelo);
        setMaterial(material);
        setTipoAro(tipoAro);
        setForma(forma);
        setColor(color);
        setPrecio(precio);
        setStock(stock);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        validarTextoObligatorio(id, "identificador");
        this.id = id.trim();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        validarTextoObligatorio(marca, "marca");
        this.marca = marca.trim();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        validarTextoObligatorio(modelo, "modelo");
        this.modelo = modelo.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        validarTextoObligatorio(material, "material");
        this.material = material.trim();
    }

    public String getTipoAro() {
        return tipoAro;
    }

    public void setTipoAro(String tipoAro) {
        validarTextoObligatorio(tipoAro, "tipo de aro");
        this.tipoAro = tipoAro.trim();
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        validarTextoObligatorio(forma, "forma");
        this.forma = forma.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        validarTextoObligatorio(color, "color");
        this.color = color.trim();
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
                    "El precio de la montura no puede ser negativo."
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
                    "El stock de la montura no puede ser negativo."
            );
        }

        this.stock = stock;
    }

    // Comprueba si existe al menos una montura disponible
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

    // Agrega monturas al inventario
    public void aumentarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad que se agregará debe ser mayor que cero."
            );
        }

        stock += cantidad;
    }

    // Retira monturas cuando se realiza una venta o pedido
    public void disminuirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad que se retirará debe ser mayor que cero."
            );
        }

        if (!hayStock(cantidad)) {
            throw new IllegalStateException(
                    "Stock insuficiente de monturas. Disponible: "
                            + stock + ", solicitado: " + cantidad + "."
            );
        }

        stock -= cantidad;
    }

    // Permite identificar monturas antes de agotarse
    public boolean tieneStockBajo(int limite) {
        if (limite < 0) {
            throw new IllegalArgumentException(
                    "El límite de stock no puede ser negativo."
            );
        }

        return stock <= limite;
    }

    // Devuelve una descripción breve del estilo de la montura
    public String obtenerCaracteristicas() {
        return forma
                + " | " + tipoAro
                + " | " + material
                + " | " + color;
    }

    // Calcula el valor económico de todas las unidades disponibles
    public double calcularValorInventario() {
        return precio * stock;
    }

    private void validarTextoObligatorio(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " es obligatorio."
            );
        }
    }

    @Override
    public String toString() {
        return "Montura [" + id + "]"
                + " | Marca: " + marca
                + " | Modelo: " + modelo
                + "\n  Estilo: " + forma
                + " | Tipo de aro: " + tipoAro
                + " | Material: " + material
                + " | Color: " + color
                + "\n  Precio: S/ " + String.format("%.2f", precio)
                + " | Stock: " + stock + " unidades";
    }
}