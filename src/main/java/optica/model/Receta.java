package main.java.optica.model;

import java.time.LocalDate;


public class Receta {

    private String id;
    private String pacienteId;
    private String doctorId;

    // Ojo Derecho (OD)
    private double odEsfera;
    private double odCilindro;
    private int odEje;
    private double odAdicion;

    // Ojo Izquierdo (OI)
    private double oiEsfera;
    private double oiCilindro;
    private int oiEje;
    private double oiAdicion;

    // Datos Técnicos de Montaje y Estructura
    private int distanciaPupilar;    // DP en milímetros (ej: 62)
    private int alturaCornea;        // Altura en milímetros (ej: 18)
    private String tipoLunaRecomendada; // Ej: "Resina Filtro Azul", "Policarbonato"
    private LocalDate fechaEmision;

    // Constructor completo (será invocado por el RecetaBuilder)
    public Receta(String id, String pacienteId, String doctorId, double odEsfera, double odCilindro, int odEje,
                  double odAdicion, double oiEsfera, double oiCilindro, int oiEje, double oiAdicion,
                  int distanciaPupilar, int alturaCornea, String tipoLunaRecomendada, LocalDate fechaEmision) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.odEsfera = odEsfera;
        this.odCilindro = odCilindro;
        this.odEje = odEje;
        this.odAdicion = odAdicion;
        this.oiEsfera = oiEsfera;
        this.oiCilindro = oiCilindro;
        this.oiEje = oiEje;
        this.oiAdicion = oiAdicion;
        this.distanciaPupilar = distanciaPupilar;
        this.alturaCornea = alturaCornea;
        this.tipoLunaRecomendada = tipoLunaRecomendada;
        this.fechaEmision = fechaEmision;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPacienteId() { return pacienteId; }
    public void setPacienteId(String pacienteId) { this.pacienteId = pacienteId; }

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public double getOdEsfera() { return odEsfera; }
    public void setOdEsfera(double odEsfera) { this.odEsfera = odEsfera; }

    public double getOdCilindro() { return odCilindro; }
    public void setOdCilindro(double odCilindro) { this.odCilindro = odCilindro; }

    public int getOdEje() { return odEje; }
    public void setOdEje(int odEje) { this.odEje = odEje; }

    public double getOdAdicion() { return odAdicion; }
    public void setOdAdicion(double odAdicion) { this.odAdicion = odAdicion; }

    public double getOiEsfera() { return oiEsfera; }
    public void setOiEsfera(double oiEsfera) { this.oiEsfera = oiEsfera; }

    public double getOiCilindro() { return oiCilindro; }
    public void setOiCilindro(double oiCilindro) { this.oiCilindro = oiCilindro; }

    public int getOiEje() { return oiEje; }
    public void setOiEje(int oiEje) { this.oiEje = oiEje; }

    public double getOiAdicion() { return oiAdicion; }
    public void setOiAdicion(double oiAdicion) { this.oiAdicion = oiAdicion; }

    public int getDistanciaPupilar() { return distanciaPupilar; }
    public void setDistanciaPupilar(int distanciaPupilar) { this.distanciaPupilar = distanciaPupilar; }

    public int getAlturaCornea() { return alturaCornea; }
    public void setAlturaCornea(int alturaCornea) { this.alturaCornea = alturaCornea; }

    public String getTipoLunaRecomendada() { return tipoLunaRecomendada; }
    public void setTipoLunaRecomendada(String tipoLunaRecomendada) { this.tipoLunaRecomendada = tipoLunaRecomendada; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    @Override
    public String toString() {
        return "Receta [" + id + "] | Paciente ID: " + pacienteId + " | Emision: " + fechaEmision +
                "\n  OD: Esf: " + odEsfera + " / Cil: " + odCilindro + " x " + odEje + " (Add: " + odAdicion + ")" +
                "\n  OI: Esf: " + oiEsfera + " / Cil: " + oiCilindro + " x " + oiEje + " (Add: " + oiAdicion + ")" +
                "\n  Especificaciones Laboratorio -> DP: " + distanciaPupilar + "mm | Altura: " + alturaCornea + "mm | Sugerencia: " + tipoLunaRecomendada;
    }
}