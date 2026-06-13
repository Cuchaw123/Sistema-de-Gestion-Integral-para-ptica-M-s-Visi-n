package main.java.optica.model;


public class LenteRequest {

    private String marca;
    private String material;
    private String tipoDiseño;
    private String tratamiento;
    private double precioBase;
    private int stock;

    // Constructor vacío
    public LenteRequest() {
    }

    // Constructor completo
    public LenteRequest(String marca, String material, String tipoDiseño, String tratamiento, double precioBase, int stock) {
        this.marca = marca;
        this.material = material;
        this.tipoDiseño = tipoDiseño;
        this.tratamiento = tratamiento;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    // Getters y Setters
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
}