package main.java.optica.model;


public class DescuentoBuilder {

    private String id;
    private String nombre;
    private String tipo;
    private double valor;
    private boolean activo;

    public DescuentoBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public DescuentoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DescuentoBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public DescuentoBuilder setValor(double valor) {
        this.valor = valor;
        return this;
    }

    public DescuentoBuilder setActivo(boolean activo) {
        this.activo = activo;
        return this;
    }


    public Descuento build() {
        return new Descuento(id, nombre, tipo, valor, activo);
    }
}