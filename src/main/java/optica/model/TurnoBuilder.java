package main.java.optica.model;

import java.time.LocalTime;


public class TurnoBuilder {

    private String id;
    private String nombre;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private boolean activo;

    public TurnoBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public TurnoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TurnoBuilder setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
        return this;
    }

    public TurnoBuilder setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
        return this;
    }

    public TurnoBuilder setActivo(boolean activo) {
        this.activo = activo;
        return this;
    }


    public Turno build() {
        return new Turno(id, nombre, horaInicio, horaFin, activo);
    }
}