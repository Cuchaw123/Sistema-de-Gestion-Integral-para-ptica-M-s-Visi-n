package main.java.optica.model;


public class RecetaResponse {

    private String recetaId;
    private String pacienteNombre;
    private String odFormateado;
    private String oiFormateado;
    private String datosMontaje; // DP y ALT
    private String mensaje;

    // Constructor vacío obligatorio
    public RecetaResponse() {
    }

    // Constructor completo
    public RecetaResponse(String recetaId, String pacienteNombre, String odFormateado, String oiFormateado, String datosMontaje, String mensaje) {
        this.recetaId = recetaId;
        this.pacienteNombre = pacienteNombre;
        this.odFormateado = odFormateado;
        this.oiFormateado = oiFormateado;
        this.datosMontaje = datosMontaje;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getRecetaId() { return recetaId; }
    public void setRecetaId(String recetaId) { this.recetaId = recetaId; }

    public String getPacienteNombre() { return pacienteNombre; }
    public void setPacienteNombre(String pacienteNombre) { this.pacienteNombre = pacienteNombre; }

    public String getOdFormateado() { return odFormateado; }
    public void setOdFormateado(String odFormateado) { this.odFormateado = odFormateado; }

    public String getOiFormateado() { return oiFormateado; }
    public void setOiFormateado(String oiFormateado) { this.oiFormateado = oiFormateado; }

    public String getDatosMontaje() { return datosMontaje; }
    public void setDatosMontaje(String datosMontaje) { this.datosMontaje = datosMontaje; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String toString() {
        return "=======================================\n" +
                "       ORDEN DE LABORATORIO ÓPTICO     \n" +
                "=======================================\n" +
                " Registro:   " + mensaje + "\n" +
                " Receta N°:  " + recetaId + "\n" +
                " Paciente:   " + pacienteNombre + "\n" +
                "---------------------------------------\n" +
                " Ojo Derecho (OD):  " + odFormateado + "\n" +
                " Ojo Izquierdo(OI):  " + oiFormateado + "\n" +
                "---------------------------------------\n" +
                " Parámetros Técnicos: " + datosMontaje + "\n" +
                "=======================================\n";
    }
}