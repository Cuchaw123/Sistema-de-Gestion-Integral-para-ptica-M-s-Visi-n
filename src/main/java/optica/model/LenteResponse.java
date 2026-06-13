package main.java.optica.model;


public class LenteResponse {

    private String id;
    private String descripcionComercial; // Ej: "Essilor Monofocal Policarbonato"
    private String tratamiento;
    private double precioFinal;
    private int stockActual;
    private String mensaje;

    // Constructor vacío
    public LenteResponse() {
    }

    // Constructor completo
    public LenteResponse(String id, String descripcionComercial, String tratamiento, double precioFinal, int stockActual, String mensaje) {
        this.id = id;
        this.descripcionComercial = descripcionComercial;
        this.tratamiento = tratamiento;
        this.precioFinal = precioFinal;
        this.stockActual = stockActual;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDescripcionComercial() { return descripcionComercial; }
    public void setDescripcionComercial(String descripcionComercial) { this.descripcionComercial = descripcionComercial; }

    public String getTratamiento() { return tratamiento; }
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }

    public double getPrecioFinal() { return precioFinal; }
    public void setPrecioFinal(double precioFinal) { this.precioFinal = precioFinal; }

    public int getStockActual() { return stockActual; }
    public void setStockActual(int stockActual) { this.stockActual = stockActual; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String toString() {
        return "=== CONTROL DE INVENTARIO: LENTES ===\n" +
                " Operación: " + mensaje + "\n" +
                " ID Lente:  " + id + "\n" +
                " Producto:  " + descripcionComercial + "\n" +
                " Filtros:   " + tratamiento + "\n" +
                " Precio:    S/. " + String.format("%.2f", precioFinal) + " | Stock: " + stockActual + " und.\n" +
                "=======================================";
    }
}