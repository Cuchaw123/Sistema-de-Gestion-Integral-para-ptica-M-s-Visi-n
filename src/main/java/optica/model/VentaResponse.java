package main.java.optica.model;


public class VentaResponse {

    private String idVenta;
    private String fechaFormateada;
    private double subTotal;
    private double igv;
    private double totalNeto;
    private String mensaje;

    // Constructor vacío obligatorio
    public VentaResponse() {
    }

    // Constructor completo
    public VentaResponse(String idVenta, String fechaFormateada, double subTotal, double igv, double totalNeto, String mensaje) {
        this.idVenta = idVenta;
        this.fechaFormateada = fechaFormateada;
        this.subTotal = subTotal;
        this.igv = igv;
        this.totalNeto = totalNeto;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getIdVenta() { return idVenta; }
    public void setIdVenta(String idVenta) { this.idVenta = idVenta; }

    public String getFechaFormateada() { return fechaFormateada; }
    public void setFechaFormateada(String fechaFormateada) { this.fechaFormateada = fechaFormateada; }

    public double getSubTotal() { return subTotal; }
    public void setSubTotal(double subTotal) { this.subTotal = subTotal; }

    public double getIgv() { return igv; }
    public void setIgv(double igv) { this.igv = igv; }

    public double getTotalNeto() { return totalNeto; }
    public void setTotalNeto(double totalNeto) { this.totalNeto = totalNeto; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String toString() {
        return "=======================================\n" +
                "       ÓPTICA MÁS VISIÓN - BOLETA      \n" +
                "=======================================\n" +
                " Estado:     " + mensaje + "\n" +
                " Nro. Comp:  " + idVenta + "\n" +
                " Fecha:      " + fechaFormateada + "\n" +
                "---------------------------------------\n" +
                " Gravada:    S/. " + String.format("%.2f", subTotal) + "\n" +
                " I.G.V (18%):S/. " + String.format("%.2f", igv) + "\n" +
                " TOTAL COBRO:S/. " + String.format("%.2f", totalNeto) + "\n" +
                "=======================================\n";
    }
}