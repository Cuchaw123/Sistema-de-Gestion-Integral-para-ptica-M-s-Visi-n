package main.java.optica.model;

/**
 * Entidad que representa una Montura (Armazón/Marco) en la Óptica Más Visión.
 */
public class Montura {

    private String id;
    private String marca;        // Ej: "Ray-Ban", "Oakley", "Vogue"
    private String modelo;       // Ej: "Aviator RB3025"
    private String material;     // Ej: "Acetato", "Titanio", "TR90"
    private String tipoAro;      // Ej: "Completo", "Semi-al aire", "Al aire"
    private String forma;        // Ej: "Rectangular", "Aviador", "Cat Eye"
    private String color;
    private double precio;
    private int stock;

    // Constructor completo (será invocado por el MonturaBuilder)
    public Montura(String id, String marca, String modelo, String material, String tipoAro, String forma, String color, double precio, int stock) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.material = material;
        this.tipoAro = tipoAro;
        this.forma = forma;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getTipoAro() { return tipoAro; }
    public void setTipoAro(String tipoAro) { this.tipoAro = tipoAro; }

    public String getForma() { return forma; }
    public void setForma(String forma) { this.forma = forma; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Montura [" + id + "] " + marca + " - Mod: " + modelo +
                "\n  Estilo: " + forma + " (" + tipoAro + ") | Material: " + material + " | Color: " + color +
                "\n  Precio: S/. " + precio + " | Stock: " + stock + " und.";
    }
}