package main.java.optica.model;

/**
 * Request para capturar los datos de refracción y montaje
 * al registrar o actualizar una Receta en el sistema.
 */
public class RecetaRequest {

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

    // 1. Constructor vacío obligatorio
    public RecetaRequest() {
    }

    // 2. Constructor completo corregido
    public RecetaRequest(String pacienteId, String doctorId, double odEsfera, double odCilindro, int odEje,
                         double odAdicion, double oiEsfera, double oiCilindro, int oiEje, double oiAdicion,
                         int distanciaPupilar, int alturaCornea, String tipoLunaRecomendada) {
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
    }

    // 3. Getters y Setters
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
}