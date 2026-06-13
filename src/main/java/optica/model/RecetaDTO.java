package main.java.optica.model;

import java.io.Serializable;
import java.time.LocalDate;


public class RecetaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String pacienteId;
    private String tipoLunaRecomendada;
    private LocalDate fechaEmision;

    // Parámetros básicos resumidos de ambos ojos (Esfera / Cilindro)
    private String medidaResumidaOD;
    private String medidaResumidaOI;

    // Constructor vacío obligatorio
    public RecetaDTO() {
    }

    // Constructor completo
    public RecetaDTO(String id, String pacienteId, String tipoLunaRecomendada, LocalDate fechaEmision, String medidaResumidaOD, String medidaResumidaOI) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.tipoLunaRecomendada = tipoLunaRecomendada;
        this.fechaEmision = fechaEmision;
        this.medidaResumidaOD = medidaResumidaOD;
        this.medidaResumidaOI = medidaResumidaOI;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getTipoLunaRecomendada() {
        return tipoLunaRecomendada;
    }

    public void setTipoLunaRecomendada(String tipoLunaRecomendada) {
        this.tipoLunaRecomendada = tipoLunaRecomendada;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getMedidaResumidaOD() {
        return medidaResumidaOD;
    }

    public void setMedidaResumidaOD(String medidaResumidaOD) {
        this.medidaResumidaOD = medidaResumidaOD;
    }

    public String getMedidaResumidaOI() {
        return medidaResumidaOI;
    }

    public void setMedidaResumidaOI(String medidaResumidaOI) {
        this.medidaResumidaOI = medidaResumidaOI;
    }

    @Override
    public String toString() {
        return "RecetaDTO {" +
                "ID='" + id + '\'' +
                ", Paciente='" + pacienteId + '\'' +
                ", OD='" + medidaResumidaOD + '\'' +
                ", OI='" + medidaResumidaOI + '\'' +
                ", Luna='" + tipoLunaRecomendada + '\'' +
                '}';
    }
}