package main.java.optica.model;


public class TurnoResponse {

    private String id;
    private String nombreTurno;
    private String rangoHorario; // Formato de texto para mostrar "09:00 - 13:00"
    private String estadoVisual;
    private String mensaje;

    // Constructor vacío obligatorio
    public TurnoResponse() {
    }

    // Constructor completo
    public TurnoResponse(String id, String nombreTurno, String rangoHorario, String estadoVisual, String mensaje) {
        this.id = id;
        this.nombreTurno = nombreTurno;
        this.rangoHorario = rangoHorario;
        this.estadoVisual = estadoVisual;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreTurno() { return nombreTurno; }
    public void setNombreTurno(String nombreTurno) { this.nombreTurno = nombreTurno; }

    public String getRangoHorario() { return rangoHorario; }
    public void setRangoHorario(String rangoHorario) { this.rangoHorario = rangoHorario; }

    public String getEstadoVisual() { return estadoVisual; }
    public void setEstadoVisual(String estadoVisual) { this.estadoVisual = estadoVisual; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String toString() {
        return "=======================================\n" +
                "        PLANIFICACIÓN DE TURNOS        \n" +
                "=======================================\n" +
                " Operación:  " + mensaje + "\n" +
                " Código:     " + id + "\n" +
                " Bloque:     " + nombreTurno + "\n" +
                " Condición:  " + estadoVisual + "\n" +
                "---------------------------------------\n" +
                " Horario:    " + rangoHorario + "\n" +
                "=======================================\n";
    }
}