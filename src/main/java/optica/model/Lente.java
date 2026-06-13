package main.java.optica.model;


public class Lente {

    private String id;
    private String marca;         // Ej: "Essilor", "Crizal", "Generic"
    private String material;      // Ej: "Policarbonato", "Resina Índice 1.56", "Cristal"
    private String tipoDiseño;    // Ej: "Monofocal", "Bifocal", "Progresivo"
    private String tratamiento;   // Ej: "Antireflex Superior", "Blue Defense", "Fotocromático"
    private double precioBase;
    private int stock;

    // Constructor completo (será invocado por el LenteBuilder)
    public Lente(String id, String marca, String material, String tipoDiseño, String tratamiento, double precioBase, int stock) {
        this.id = id;
        this.marca = marca;
        this.material = material;
        this.tipoDiseño = tipoDiseño;
        this.tratamiento = tratamiento;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getTipoDiseño() { return tipoDiseño; }
    public void setTipoDiseño(String tipoDiseño) { this.tipoDiseño = tipoDiseño; }

    public String getTratamiento() { return tratamiento; }
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Lente [" + id + "] " + marca + " (" + tipoDiseño + ") " +
                "\n  Material: " + material + " | Tratamiento: " + tratamiento +
                "\n  Precio: S/. " + precioBase + " | Stock: " + stock + " und.";
    }
}