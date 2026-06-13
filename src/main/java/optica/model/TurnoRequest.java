package main.java.optica.model;

import java.time.LocalTime;


public class TurnoRequest {

    private String nombre;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    // Constructor vacío obligatorio
    public TurnoRequest() {
    }

    // Constructor completo
    public TurnoRequest(String nombre, LocalTime horaInicio, LocalTime horaFin) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }
}