package main.java.optica.model;

import java.time.LocalDateTime;

public class HistorialOptico {

    private String id;
    private String pacienteId;
    private String optometristaId;
    private LocalDateTime fechaExamen;

    // Resultado de la evaluación visual
    private String diagnostico;
    private String observaciones;

    // Medidas del ojo derecho
    private double odEsfera;
    private double odCilindro;
    private int odEje;
    private double odAdicion;

    // Medidas del ojo izquierdo
    private double oiEsfera;
    private double oiCilindro;
    private int oiEje;
    private double oiAdicion;

    public HistorialOptico(
            String id,
            String pacienteId,
            String optometristaId,
            LocalDateTime fechaExamen,
            String diagnostico,
            String observaciones,
            double odEsfera,
            double odCilindro,
            int odEje,
            double odAdicion,
            double oiEsfera,
            double oiCilindro,
            int oiEje,
            double oiAdicion
    ) {
        setId(id);
        setPacienteId(pacienteId);
        setOptometristaId(optometristaId);
        setFechaExamen(fechaExamen);
        setDiagnostico(diagnostico);
        setObservaciones(observaciones);

        setOdEsfera(odEsfera);
        setOdCilindro(odCilindro);
        setOdEje(odEje);
        setOdAdicion(odAdicion);

        setOiEsfera(oiEsfera);
        setOiCilindro(oiCilindro);
        setOiEje(oiEje);
        setOiAdicion(oiAdicion);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = validarTexto(id, "El ID del historial es obligatorio.");
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = validarTexto(
                pacienteId,
                "El ID del paciente es obligatorio."
        );
    }

    public String getOptometristaId() {
        return optometristaId;
    }

    public void setOptometristaId(String optometristaId) {
        this.optometristaId = validarTexto(
                optometristaId,
                "El ID del optometrista es obligatorio."
        );
    }

    /*
     * Métodos temporales para que las demás clases antiguas
     * no fallen mientras se cambia doctorId por optometristaId.
     */
    @Deprecated
    public String getDoctorId() {
        return optometristaId;
    }

    @Deprecated
    public void setDoctorId(String doctorId) {
        setOptometristaId(doctorId);
    }

    public LocalDateTime getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(LocalDateTime fechaExamen) {
        if (fechaExamen == null) {
            throw new IllegalArgumentException(
                    "La fecha del examen es obligatoria."
            );
        }

        this.fechaExamen = fechaExamen;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = validarTexto(
                diagnostico,
                "El resultado de la evaluación visual es obligatorio."
        );
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones == null
                ? ""
                : observaciones.trim();
    }

    public double getOdEsfera() {
        return odEsfera;
    }

    public void setOdEsfera(double odEsfera) {
        this.odEsfera = odEsfera;
    }

    public double getOdCilindro() {
        return odCilindro;
    }

    public void setOdCilindro(double odCilindro) {
        this.odCilindro = odCilindro;
    }

    public int getOdEje() {
        return odEje;
    }

    public void setOdEje(int odEje) {
        validarEje(odEje, "OD");
        this.odEje = odEje;
    }

    public double getOdAdicion() {
        return odAdicion;
    }

    public void setOdAdicion(double odAdicion) {
        this.odAdicion = odAdicion;
    }

    public double getOiEsfera() {
        return oiEsfera;
    }

    public void setOiEsfera(double oiEsfera) {
        this.oiEsfera = oiEsfera;
    }

    public double getOiCilindro() {
        return oiCilindro;
    }

    public void setOiCilindro(double oiCilindro) {
        this.oiCilindro = oiCilindro;
    }

    public int getOiEje() {
        return oiEje;
    }

    public void setOiEje(int oiEje) {
        validarEje(oiEje, "OI");
        this.oiEje = oiEje;
    }

    public double getOiAdicion() {
        return oiAdicion;
    }

    public void setOiAdicion(double oiAdicion) {
        this.oiAdicion = oiAdicion;
    }

    private String validarTexto(String valor, String mensaje) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }

        return valor.trim();
    }

    private void validarEje(int eje, String ojo) {
        if (eje < 0 || eje > 180) {
            throw new IllegalArgumentException(
                    "El eje del " + ojo + " debe estar entre 0 y 180 grados."
            );
        }
    }

    @Override
    public String toString() {
        return "Historial óptico [" + id + "]"
                + " | Paciente ID: " + pacienteId
                + " | Optometrista ID: " + optometristaId
                + "\nFecha del examen: " + fechaExamen
                + "\nResultado visual: " + diagnostico
                + "\nObservaciones: " + observaciones
                + "\n[OD] ESF: " + odEsfera
                + " | CIL: " + odCilindro
                + " | EJE: " + odEje + "°"
                + " | ADD: " + odAdicion
                + "\n[OI] ESF: " + oiEsfera
                + " | CIL: " + oiCilindro
                + " | EJE: " + oiEje + "°"
                + " | ADD: " + oiAdicion;
    }
}