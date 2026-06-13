package main.java.optica.model;


public class HistorialResponse {

    private String idHistorial;
    private String nombrePaciente;
    private String nombreDoctor;
    private String diagnostico;

    // Cadenas formateadas listas para visualización (ej: "-2.50", "+1.00", "180°")
    private String medidaOD;
    private String medidaOI;
    private String observaciones;
    private String mensajeOperacion;

    // Constructor vacío
    public HistorialResponse() {
    }

    // Constructor completo
    public HistorialResponse(String idHistorial, String nombrePaciente, String nombreDoctor, String diagnostico,
                             String medidaOD, String medidaOI, String observaciones, String mensajeOperacion) {
        this.idHistorial = idHistorial;
        this.nombrePaciente = nombrePaciente;
        this.nombreDoctor = nombreDoctor;
        this.diagnostico = diagnostico;
        this.medidaOD = medidaOD;
        this.medidaOI = medidaOI;
        this.observaciones = observaciones;
        this.mensajeOperacion = mensajeOperacion;
    }

    // Getters y Setters
    public String getIdHistorial() { return idHistorial; }
    public void setIdHistorial(String idHistorial) { this.idHistorial = idHistorial; }

    public String getNombrePaciente() { return nombrePaciente; }
    public void setNombrePaciente(String nombrePaciente) { this.nombrePaciente = nombrePaciente; }

    public String getNombreDoctor() { return nombreDoctor; }
    public void setNombreDoctor(String nombreDoctor) { this.nombreDoctor = nombreDoctor; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getMedidaOD() { return medidaOD; }
    public void setMedidaOD(String medidaOD) { this.medidaOD = medidaOD; }

    public String getMedidaOI() { return medidaOI; }
    public void setMedidaOI(String medidaOI) { this.medidaOI = medidaOI; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getMensajeOperacion() { return mensajeOperacion; }
    public void setMensajeOperacion(String mensajeOperacion) { this.mensajeOperacion = mensajeOperacion; }

    @Override
    public String toString() {
        return "===================================================\n" +
                "             RECETA DE MEDIDA DE VISTA             \n" +
                "===================================================\n" +
                " Reg: " + idHistorial + " | " + mensajeOperacion + "\n" +
                " Paciente: " + nombrePaciente + "\n" +
                " Especialista: " + nombreDoctor + "\n" +
                " Diagnóstico:  " + diagnostico + "\n" +
                "---------------------------------------------------\n" +
                " OJO DERECHO (OD)  : " + medidaOD + "\n" +
                " OJO IZQUIERDO (OI) : " + medidaOI + "\n" +
                "---------------------------------------------------\n" +
                " Indicaciones: " + observaciones + "\n" +
                "===================================================\n";
    }
}