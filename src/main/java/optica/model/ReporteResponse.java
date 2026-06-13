package main.java.optica.model;


public class ReporteResponse {

    private String reporteId;
    private String tituloReporte;
    private String fechaHoraFormateada;
    private int operacionesContadas;
    private double balanceSoles;
    private String estadoReporte;

    // Constructor vacío obligatorio
    public ReporteResponse() {
    }

    // Constructor completo
    public ReporteResponse(String reporteId, String tituloReporte, String fechaHoraFormateada,
                           int operacionesContadas, double balanceSoles, String estadoReporte) {
        this.reporteId = reporteId;
        this.tituloReporte = tituloReporte;
        this.fechaHoraFormateada = fechaHoraFormateada;
        this.operacionesContadas = operacionesContadas;
        this.balanceSoles = balanceSoles;
        this.estadoReporte = estadoReporte;
    }

    // Getters y Setters
    public String getReporteId() { return reporteId; }
    public void setReporteId(String reporteId) { this.reporteId = reporteId; }

    public String getTituloReporte() { return tituloReporte; }
    public void setTituloReporte(String tituloReporte) { this.tituloReporte = tituloReporte; }

    public String getFechaHoraFormateada() { return fechaHoraFormateada; }
    public void setFechaHoraFormateada(String fechaHoraFormateada) { this.fechaHoraFormateada = fechaHoraFormateada; }

    public int getOperacionesContadas() { return operacionesContadas; }
    public void setOperacionesContadas(int operacionesContadas) { this.operacionesContadas = operacionesContadas; }

    public double getBalanceSoles() { return balanceSoles; }
    public void setBalanceSoles(double balanceSoles) { this.balanceSoles = balanceSoles; }

    public String getEstadoReporte() { return estadoReporte; }
    public void setEstadoReporte(String estadoReporte) { this.estadoReporte = estadoReporte; }

    @Override
    public String toString() {
        return "=======================================\n" +
                "         REPORTE GERENCIAL DE ÓPTICA   \n" +
                "=======================================\n" +
                " ID Cierre:  " + reporteId + "\n" +
                " Auditoría:  " + tituloReporte + "\n" +
                " Emitido el: " + fechaHoraFormateada + "\n" +
                " Estado:     " + estadoReporte + "\n" +
                "---------------------------------------\n" +
                " Vol. Transacciones: " + operacionesContadas + " oper.\n" +
                " BALANCE TOTAL:      S/. " + String.format("%.2f", balanceSoles) + "\n" +
                "=======================================\n";
    }
}