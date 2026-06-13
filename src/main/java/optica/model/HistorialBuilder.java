package main.java.optica.model;

import java.time.LocalDateTime;


public class HistorialBuilder {

    private String id;
    private String pacienteId;
    private String doctorId;
    private LocalDateTime fechaExamen;
    private String diagnostico;
    private String observaciones;
    private double odEsfera;
    private double odCilindro;
    private int odEje;
    private double odAdicion;
    private double oiEsfera;
    private double oiCilindro;
    private int oiEje;
    private double oiAdicion;

    public HistorialBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public HistorialBuilder setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
        return this;
    }

    public HistorialBuilder setDoctorId(String doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public HistorialBuilder setFechaExamen(LocalDateTime fechaExamen) {
        this.fechaExamen = fechaExamen;
        return this;
    }

    public HistorialBuilder setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
        return this;
    }

    public HistorialBuilder setObservaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public HistorialBuilder setOdEsfera(double odEsfera) {
        this.odEsfera = odEsfera;
        return this;
    }

    public HistorialBuilder setOdCilindro(double odCilindro) {
        this.odCilindro = odCilindro;
        return this;
    }

    public HistorialBuilder setOdEje(int odEje) {
        this.odEje = odEje;
        return this;
    }

    public HistorialBuilder setOdAdicion(double odAdicion) {
        this.odAdicion = odAdicion;
        return this;
    }

    public HistorialBuilder setOiEsfera(double oiEsfera) {
        this.oiEsfera = oiEsfera;
        return this;
    }

    public HistorialBuilder setOiCilindro(double oiCilindro) {
        this.oiCilindro = oiCilindro;
        return this;
    }

    public HistorialBuilder setOiEje(int oiEje) {
        this.oiEje = oiEje;
        return this;
    }

    public HistorialBuilder setOiAdicion(double oiAdicion) {
        this.oiAdicion = oiAdicion;
        return this;
    }


    public Historial build() {
        return new Historial(id, pacienteId, doctorId, fechaExamen, diagnostico, observaciones,
                odEsfera, odCilindro, odEje, odAdicion,
                oiEsfera, oiCilindro, oiEje, oiAdicion);
    }
}