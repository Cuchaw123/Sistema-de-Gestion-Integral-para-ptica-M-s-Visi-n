package main.java.optica.model;

import java.time.LocalTime;


public class Turno {

    private String id;
    private String nombre;        // Ej:  "Tarde Operativo", "Sabatino Corto"
    private LocalTime horaInicio; // Hora de apertura o inicio del bloque
    private LocalTime horaFin;    // Hora de cierre o término del bloque
    private boolean activo;       // true = Habilitado para asignación, false = Desactivado

    // Constructor completo (será invocado por el TurnoBuilder)
    public Turno(String id, String nombre, LocalTime horaInicio, LocalTime horaFin, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.activo = activo;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return "Turno [" + id + "] " + nombre + " | Horario: " + horaInicio + " a " + horaFin +
                " | Estado: " + (activo ? "Vigente" : "Suspendido");
    }
}