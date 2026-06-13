package main.java.optica.model;

import java.time.LocalDate;


public class RecetaBuilder {

    private String id;
    private String pacienteId;
    private String doctorId;
    private double odEsfera;
    private double odCilindro;
    private int odEje;
    private double odAdicion;
    private double oiEsfera;
    private double oiCilindro;
    private int oiEje;
    private double oiAdicion;
    private int distanciaPupilar;
    private int alturaCornea;
    private String tipoLunaRecomendada;
    private LocalDate fechaEmision;

    public RecetaBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public RecetaBuilder setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
        return this;
    }

    public RecetaBuilder setDoctorId(String doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public RecetaBuilder setOdEsfera(double odEsfera) {
        this.odEsfera = odEsfera;
        return this;
    }

    public RecetaBuilder setOdCilindro(double odCilindro) {
        this.odCilindro = odCilindro;
        return this;
    }

    public RecetaBuilder setOdEje(int odEje) {
        this.odEje = odEje;
        return this;
    }

    public RecetaBuilder setOdAdicion(double odAdicion) {
        this.odAdicion = odAdicion;
        return this;
    }

    public RecetaBuilder setOiEsfera(double oiEsfera) {
        this.oiEsfera = oiEsfera;
        return this;
    }

    public RecetaBuilder setOiCilindro(double oiCilindro) {
        this.oiCilindro = oiCilindro;
        return this;
    }

    public RecetaBuilder setOiEje(int oiEje) {
        this.oiEje = oiEje;
        return this;
    }

    public RecetaBuilder setOiAdicion(double oiAdicion) {
        this.oiAdicion = oiAdicion;
        return this;
    }

    public RecetaBuilder setDistanciaPupilar(int distanciaPupilar) {
        this.distanciaPupilar = distanciaPupilar;
        return this;
    }

    public RecetaBuilder setAlturaCornea(int alturaCornea) {
        this.alturaCornea = alturaCornea;
        return this;
    }

    public RecetaBuilder setTipoLunaRecomendada(String tipoLunaRecomendada) {
        this.tipoLunaRecomendada = tipoLunaRecomendada;
        return this;
    }

    public RecetaBuilder setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
        return this;
    }


    public Receta build() {
        return new Receta(id, pacienteId, doctorId, odEsfera, odCilindro, odEje, odAdicion,
                oiEsfera, oiCilindro, oiEje, oiAdicion, distanciaPupilar, alturaCornea,
                tipoLunaRecomendada, fechaEmision);
    }
}