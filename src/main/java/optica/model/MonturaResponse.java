package main.java.optica.model;


public class MonturaResponse {

    private String id;
    private String descripcionCorta; // Ej: "Ray-Ban Aviator (Negro)"
    private String caracteristicas;  // Ej: "Forma: Aviador | Aro: Completo"
    private double precioVenta;
    private int stockResultante;
    private String mensaje;

    // Constructor vacío
    public MonturaResponse() {
    }

    // Constructor completo
    public MonturaResponse(String id, String descripcionCorta, String caracteristicas, double precioVenta, int stockResultante, String mensaje) {
        this.id = id;
        this.descripcionCorta = descripcionCorta;
        this.caracteristicas = caracteristicas;
        this.precioVenta = precioVenta;
        this.stockResultante = stockResultante;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDescripcionCorta() { return descripcionCorta; }
    public void setDescripcionCorta(String descripcionCorta) { this.descripcionCorta = descripcionCorta; }

    public String getCaracteristicas() { return caracteristicas; }
    public void setCaracteristicas(String caracteristicas) { this.caracteristicas = caracteristicas; }

    public double getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }

    public int getStockResultante() { return stockResultante; }
    public void setStockResultante(int stockResultante) { this.stockResultante = stockResultante; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String toString() {
        return "=== CATALOGO DE VITRINA: MONTURAS ===\n" +
                " Estado:    " + mensaje + "\n" +
                " Código:     " + id + "\n" +
                " Modelo:     " + descripcionCorta + "\n" +
                " Detalles:   " + caracteristicas + "\n" +
                " Precio:     S/. " + String.format("%.2f", precioVenta) + " | Stock: " + stockResultante + " und.\n" +
                "=======================================";
    }
}