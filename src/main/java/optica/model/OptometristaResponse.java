package main.java.optica.model;

public class OptometristaResponse {

    private String id;
    private String nombreCompleto;
    private String areaAtencion;
    private String numeroRegistroProfesional;
    private String estado;
    private String mensaje;

    public OptometristaResponse() {
    }

    public OptometristaResponse(
            String id,
            String nombreCompleto,
            String areaAtencion,
            String numeroRegistroProfesional,
            String estado,
            String mensaje
    ) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.areaAtencion = areaAtencion;
        this.numeroRegistroProfesional = numeroRegistroProfesional;
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getAreaAtencion() {
        return areaAtencion;
    }

    public void setAreaAtencion(String areaAtencion) {
        this.areaAtencion = areaAtencion;
    }

    public String getNumeroRegistroProfesional() {
        return numeroRegistroProfesional;
    }

    public void setNumeroRegistroProfesional(
            String numeroRegistroProfesional
    ) {
        this.numeroRegistroProfesional = numeroRegistroProfesional;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    // Compatibilidad temporal con nombres antiguos

    @Deprecated
    public String getEspecialidad() {
        return areaAtencion;
    }

    @Deprecated
    public void setEspecialidad(String especialidad) {
        this.areaAtencion = especialidad;
    }

    @Deprecated
    public String getNroColegiatura() {
        return numeroRegistroProfesional;
    }

    @Deprecated
    public void setNroColegiatura(String nroColegiatura) {
        this.numeroRegistroProfesional = nroColegiatura;
    }

    @Override
    public String toString() {
        return "=== REGISTRO DE OPTOMETRISTA ===\n" +
                "Resultado: " + mensaje + "\n" +
                "ID Optometrista: " + id + "\n" +
                "Nombre: " + nombreCompleto + "\n" +
                "Área de atención: " + areaAtencion + "\n" +
                "Registro profesional: " +
                numeroRegistroProfesional + "\n" +
                "Estado: " + estado + "\n" +
                "================================";
    }
}