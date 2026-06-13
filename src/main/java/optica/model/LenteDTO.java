package main.java.optica.model;

import java.io.Serializable;


public class LenteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String marca;
    private String material;
    private String tipoDiseño;
    private String tratamiento;
    private double precioBase;
    private int stock;

    // Constructor vacío obligatorio
    public LenteDTO() {
    }

    // Constructor completo
    public LenteDTO(String id, String marca, String material, String tipoDiseño, String tratamiento, double precioBase, int stock) {
        this.id = id;
        this.marca = marca;
        this.material = material;
        this.tipoDiseño = tipoDiseño;
        this.tratamiento = tratamiento;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipoDiseño() {
        return tipoDiseño;
    }

    public void setTipoDiseño(String tipoDiseño) {
        this.tipoDiseño = tipoDiseño;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "LenteDTO{" +
                "id='" + id + '\'' +
                ", marca='" + marca + '\'' +
                ", material='" + material + '\'' +
                ", tipoDiseño='" + tipoDiseño + '\'' +
                ", tratamiento='" + tratamiento + '\'' +
                ", precioBase=" + precioBase +
                ", stock=" + stock +
                '}';
    }
}