package main.java.optica.model;

import java.time.LocalDateTime;

public class HistorialOpticoBuilder {

    private String id;
    private String pacienteId;
    private String optometristaId;
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

    public HistorialOpticoBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public HistorialOpticoBuilder setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
        return this;
    }

    public HistorialOpticoBuilder setOptometristaId(String optometristaId) {
        this.optometristaId = optometristaId;
        return this;
    }

    /*
     * Método temporal de compatibilidad.
     * Se puede eliminar cuando ninguna clase use setDoctorId().
     */
    @Deprecated
    public HistorialOpticoBuilder setDoctorId(String doctorId) {
        return setOptometristaId(doctorId);
    }

    public HistorialOpticoBuilder setFechaExamen(LocalDateTime fechaExamen) {
        this.fechaExamen = fechaExamen;
        return this;
    }

    public HistorialOpticoBuilder setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
        return this;
    }

    public HistorialOpticoBuilder setObservaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public HistorialOpticoBuilder setOdEsfera(double odEsfera) {
        this.odEsfera = odEsfera;
        return this;
    }

    public HistorialOpticoBuilder setOdCilindro(double odCilindro) {
        this.odCilindro = odCilindro;
        return this;
    }

    public HistorialOpticoBuilder setOdEje(int odEje) {
        this.odEje = odEje;
        return this;
    }

    public HistorialOpticoBuilder setOdAdicion(double odAdicion) {
        this.odAdicion = odAdicion;
        return this;
    }

    public HistorialOpticoBuilder setOiEsfera(double oiEsfera) {
        this.oiEsfera = oiEsfera;
        return this;
    }

    public HistorialOpticoBuilder setOiCilindro(double oiCilindro) {
        this.oiCilindro = oiCilindro;
        return this;
    }

    public HistorialOpticoBuilder setOiEje(int oiEje) {
        this.oiEje = oiEje;
        return this;
    }

    public HistorialOpticoBuilder setOiAdicion(double oiAdicion) {
        this.oiAdicion = oiAdicion;
        return this;
    }

    public HistorialOptico build() {
        return new HistorialOptico(
                id,
                pacienteId,
                optometristaId,
                fechaExamen,
                diagnostico,
                observaciones,
                odEsfera,
                odCilindro,
                odEje,
                odAdicion,
                oiEsfera,
                oiCilindro,
                oiEje,
                oiAdicion
        );
    }
}
