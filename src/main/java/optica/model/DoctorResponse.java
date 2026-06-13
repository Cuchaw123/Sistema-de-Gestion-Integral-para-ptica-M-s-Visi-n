package main.java.optica.model;


public class DoctorResponse {

    private String id;
    private String nombreCompleto;
    private String especialidad;
    private String nroColegiatura;
    private String estado;
    private String mensaje;

    // Constructor vacío
    public DoctorResponse() {
    }

    // Constructor completo
    public DoctorResponse(String id, String nombreCompleto, String especialidad, String nroColegiatura, String estado, String mensaje) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.nroColegiatura = nroColegiatura;
        this.estado = estado;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getNroColegiatura() { return nroColegiatura; }
    public void setNroColegiatura(String nroColegiatura) { this.nroColegiatura = nroColegiatura; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String toString() {
        return "=== REGISTRO DE PERSONAL MÉDICO ===\n" +
                " Resultado: " + mensaje + "\n" +
                " ID Doctor: " + id + "\n" +
                " Personal:  " + nombreCompleto + "\n" +
                " Área:      " + especialidad + " (Reg: " + nroColegiatura + ")\n" +
                " Condición: " + estado + "\n" +
                "====================================";
    }
}