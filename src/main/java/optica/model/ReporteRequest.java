package main.java.optica.model;


public class ReporteRequest {

    private String tipoReporte;      // Ej: "CAJA" o "INVENTARIO"
    private String usuarioGenerador; // ID del administrador responsable
    private String notasFiltro;      // Comentarios o especificaciones del filtro


    public ReporteRequest() {
    }

    // Constructor completo
    public ReporteRequest(String tipoReporte, String usuarioGenerador, String notasFiltro) {
        this.tipoReporte = tipoReporte;
        this.usuarioGenerador = usuarioGenerador;
        this.notasFiltro = notasFiltro;
    }

    // Getters y Setters
    public String getTipoReporte() { return tipoReporte; }
    public void setTipoReporte(String tipoReporte) { this.tipoReporte = tipoReporte; }

    public String getUsuarioGenerador() { return usuarioGenerador; }
    public void setUsuarioGenerador(String usuarioGenerador) { this.usuarioGenerador = usuarioGenerador; }

    public String getNotasFiltro() { return notasFiltro; }
    public void setNotasFiltro(String notasFiltro) { this.notasFiltro = notasFiltro; }
}