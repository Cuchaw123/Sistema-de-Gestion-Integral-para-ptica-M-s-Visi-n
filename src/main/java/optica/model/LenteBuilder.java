package main.java.optica.model;


public class LenteBuilder {

    private String id;
    private String marca;
    private String material;
    private String tipoDiseño;
    private String tratamiento;
    private double precioBase;
    private int stock;

    public LenteBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public LenteBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public LenteBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    public LenteBuilder setTipoDiseño(String tipoDiseño) {
        this.tipoDiseño = tipoDiseño;
        return this;
    }

    public LenteBuilder setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
        return this;
    }

    public LenteBuilder setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
        return this;
    }

    public LenteBuilder setStock(int stock) {
        this.stock = stock;
        return this;
    }

    /**
     * Construye la instancia de Lente con los atributos configurados.
     * @return Una nueva instancia de Lente.
     */
    public Lente build() {
        return new Lente(id, marca, material, tipoDiseño, tratamiento, precioBase, stock);
    }
}