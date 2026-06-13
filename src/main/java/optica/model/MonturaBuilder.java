package main.java.optica.model;


public class MonturaBuilder {

    private String id;
    private String marca;
    private String modelo;
    private String material;
    private String tipoAro;
    private String forma;
    private String color;
    private double precio;
    private int stock;

    public MonturaBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public MonturaBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public MonturaBuilder setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public MonturaBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    public MonturaBuilder setTipoAro(String tipoAro) {
        this.tipoAro = tipoAro;
        return this;
    }

    public MonturaBuilder setForma(String forma) {
        this.forma = forma;
        return this;
    }

    public MonturaBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public MonturaBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public MonturaBuilder setStock(int stock) {
        this.stock = stock;
        return this;
    }

    /**
     * Construye la instancia de Montura con las propiedades configuradas.
     * @return Una nueva instancia de Montura.
     */
    public Montura build() {
        return new Montura(id, marca, modelo, material, tipoAro, forma, color, precio, stock);
    }
}