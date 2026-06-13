package main.java.optica.model;

import java.io.Serializable;


public class MonturaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String marca;
    private String modelo;
    private String material;
    private String tipoAro;
    private String forma;
    private String color;
    private double precio;
    private int stock;

    // Constructor vacío obligatorio
    public MonturaDTO() {
    }

    // Constructor completo
    public MonturaDTO(String id, String marca, String modelo, String material, String tipoAro, String forma, String color, double precio, int stock) {
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipoAro() {
        return tipoAro;
    }

    public void setTipoAro(String tipoAro) {
        this.tipoAro = tipoAro;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "MonturaDTO{" +
                "id='" + id + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", material='" + material + '\'' +
                ", tipoAro='" + tipoAro + '\'' +
                ", forma='" + forma + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}