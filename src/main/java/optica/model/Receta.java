package main.java.optica.model;

import java.time.LocalDate;

public class Receta {

    private String id;
    private String pacienteId;
    private String optometristaId;

    // Ojo derecho (OD)
    private double odEsfera;
    private double odCilindro;
    private int odEje;
    private double odAdicion;

    // Ojo izquierdo (OI)
    private double oiEsfera;
    private double oiCilindro;
    private int oiEje;
    private double oiAdicion;

    // Datos técnicos para la elaboración de los lentes
    private int distanciaPupilar;
    private int alturaCornea;
    private String tipoLunaRecomendada;
    private LocalDate fechaEmision;

    // Constructor completo utilizado por RecetaBuilder
    public Receta(
            String id,
            String pacienteId,
            String optometristaId,
            double odEsfera,
            double odCilindro,
            int odEje,
            double odAdicion,
            double oiEsfera,
            double oiCilindro,
            int oiEje,
            double oiAdicion,
            int distanciaPupilar,
            int alturaCornea,
            String tipoLunaRecomendada,
            LocalDate fechaEmision
    ) {
        setId(id);
        setPacienteId(pacienteId);
        setOptometristaId(optometristaId);

        setOdEsfera(odEsfera);
        setOdCilindro(odCilindro);
        setOdEje(odEje);
        setOdAdicion(odAdicion);

        setOiEsfera(oiEsfera);
        setOiCilindro(oiCilindro);
        setOiEje(oiEje);
        setOiAdicion(oiAdicion);

        setDistanciaPupilar(distanciaPupilar);
        setAlturaCornea(alturaCornea);
        setTipoLunaRecomendada(tipoLunaRecomendada);
        setFechaEmision(fechaEmision);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        validarIdentificador(id, "receta");
        this.id = id.trim();
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        validarIdentificador(pacienteId, "paciente");
        this.pacienteId = pacienteId.trim();
    }

    public String getOptometristaId() {
        return optometristaId;
    }

    public void setOptometristaId(String optometristaId) {
        validarIdentificador(optometristaId, "optometrista");
        this.optometristaId = optometristaId.trim();
    }

    /*
     * Métodos temporales de compatibilidad.
     * Evitan errores mientras RecetaBuilder, DTO y otras clases
     * todavía utilicen el nombre doctorId.
     */
    @Deprecated
    public String getDoctorId() {
        return optometristaId;
    }

    @Deprecated
    public void setDoctorId(String doctorId) {
        setOptometristaId(doctorId);
    }

    public double getOdEsfera() {
        return odEsfera;
    }

    public void setOdEsfera(double odEsfera) {
        validarMedidaOptica(odEsfera, -30.0, 30.0, "esfera del ojo derecho");
        this.odEsfera = odEsfera;
    }

    public double getOdCilindro() {
        return odCilindro;
    }

    public void setOdCilindro(double odCilindro) {
        validarMedidaOptica(odCilindro, -20.0, 20.0, "cilindro del ojo derecho");
        this.odCilindro = odCilindro;
    }

    public int getOdEje() {
        return odEje;
    }

    public void setOdEje(int odEje) {
        validarEje(odEje, "ojo derecho");
        this.odEje = odEje;
    }

    public double getOdAdicion() {
        return odAdicion;
    }

    public void setOdAdicion(double odAdicion) {
        validarMedidaOptica(odAdicion, 0.0, 6.0, "adición del ojo derecho");
        this.odAdicion = odAdicion;
    }

    public double getOiEsfera() {
        return oiEsfera;
    }

    public void setOiEsfera(double oiEsfera) {
        validarMedidaOptica(oiEsfera, -30.0, 30.0, "esfera del ojo izquierdo");
        this.oiEsfera = oiEsfera;
    }

    public double getOiCilindro() {
        return oiCilindro;
    }

    public void setOiCilindro(double oiCilindro) {
        validarMedidaOptica(oiCilindro, -20.0, 20.0, "cilindro del ojo izquierdo");
        this.oiCilindro = oiCilindro;
    }

    public int getOiEje() {
        return oiEje;
    }

    public void setOiEje(int oiEje) {
        validarEje(oiEje, "ojo izquierdo");
        this.oiEje = oiEje;
    }

    public double getOiAdicion() {
        return oiAdicion;
    }

    public void setOiAdicion(double oiAdicion) {
        validarMedidaOptica(oiAdicion, 0.0, 6.0, "adición del ojo izquierdo");
        this.oiAdicion = oiAdicion;
    }

    public int getDistanciaPupilar() {
        return distanciaPupilar;
    }

    public void setDistanciaPupilar(int distanciaPupilar) {
        if (distanciaPupilar < 40 || distanciaPupilar > 80) {
            throw new IllegalArgumentException(
                    "La distancia pupilar debe estar entre 40 y 80 mm."
            );
        }

        this.distanciaPupilar = distanciaPupilar;
    }

    public int getAlturaCornea() {
        return alturaCornea;
    }

    public void setAlturaCornea(int alturaCornea) {
        if (alturaCornea < 10 || alturaCornea > 40) {
            throw new IllegalArgumentException(
                    "La altura de montaje debe estar entre 10 y 40 mm."
            );
        }

        this.alturaCornea = alturaCornea;
    }

    public String getTipoLunaRecomendada() {
        return tipoLunaRecomendada;
    }

    public void setTipoLunaRecomendada(String tipoLunaRecomendada) {
        if (tipoLunaRecomendada == null || tipoLunaRecomendada.isBlank()) {
            throw new IllegalArgumentException(
                    "El tipo de luna recomendada es obligatorio."
            );
        }

        this.tipoLunaRecomendada = tipoLunaRecomendada.trim();
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        if (fechaEmision == null) {
            throw new IllegalArgumentException(
                    "La fecha de emisión es obligatoria."
            );
        }

        if (fechaEmision.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "La fecha de emisión no puede ser futura."
            );
        }

        this.fechaEmision = fechaEmision;
    }

    public boolean requiereAdicion() {
        return odAdicion > 0 || oiAdicion > 0;
    }

    public String obtenerGraduacionOjoDerecho() {
        return "OD: Esf. " + odEsfera
                + " | Cil. " + odCilindro
                + " | Eje " + odEje
                + "° | Add. " + odAdicion;
    }

    public String obtenerGraduacionOjoIzquierdo() {
        return "OI: Esf. " + oiEsfera
                + " | Cil. " + oiCilindro
                + " | Eje " + oiEje
                + "° | Add. " + oiAdicion;
    }

    private void validarIdentificador(String valor, String entidad) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "El identificador de " + entidad + " es obligatorio."
            );
        }
    }

    private void validarEje(int eje, String ojo) {
        if (eje < 0 || eje > 180) {
            throw new IllegalArgumentException(
                    "El eje del " + ojo + " debe estar entre 0 y 180 grados."
            );
        }
    }

    private void validarMedidaOptica(
            double valor,
            double minimo,
            double maximo,
            String campo
    ) {
        if (Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new IllegalArgumentException(
                    "La " + campo + " debe ser un número válido."
            );
        }

        if (valor < minimo || valor > maximo) {
            throw new IllegalArgumentException(
                    "La " + campo + " debe estar entre "
                            + minimo + " y " + maximo + "."
            );
        }
    }

    @Override
    public String toString() {
        return "Receta [" + id + "]"
                + " | Paciente: " + pacienteId
                + " | Optometrista: " + optometristaId
                + " | Emisión: " + fechaEmision
                + "\n  " + obtenerGraduacionOjoDerecho()
                + "\n  " + obtenerGraduacionOjoIzquierdo()
                + "\n  Montaje: DP " + distanciaPupilar
                + " mm | Altura " + alturaCornea
                + " mm | Luna: " + tipoLunaRecomendada;
    }
}
