package main.java.optica.model;


public class HistorialRequest {

    private String pacienteId;
    private String doctorId;
    private String diagnostico;
    private String observaciones;

    // Ojo Derecho
    private double odEsfera;
    private double odCilindro;
    private int odEje;
    private double odAdicion;

    // Ojo Izquierdo
    private double oiEsfera;
    private double oiCilindro;
    private int oiEje;
    private double oiAdicion;

    // Constructor vacío
    public HistorialRequest() {
    }

    // Constructor completo
    public HistorialRequest(String pacienteId, String doctorId, String diagnostico, String observaciones,
                            double odEsfera, double odCilindro, int odEje, double odAdicion,
                            double oiEsfera, double oiCilindro, int oiEje, double oiAdicion) {
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
        this.odEsfera = odEsfera;
        this.odCilindro = odCilindro;
        this.odEje = odEje;
        this.odAdicion = odAdicion;
        this.oiEsfera = oiEsfera;
        this.oiCilindro = oiCilindro;
        this.oiEje = oiEje;
        this.oiAdicion = oiAdicion;
    }

    // Getters y Setters
    public String getPacienteId() { return pacienteId; }
    public void setPacienteId(String pacienteId) { this.pacienteId = pacienteId; }

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

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
}