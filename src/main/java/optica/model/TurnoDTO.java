package main.java.optica.model;

import java.io.Serializable;
import java.time.LocalTime;


public class TurnoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nombre;
    private LocalTime horaInicio;

    // Constructor vacío obligatorio
    public TurnoDTO() {
    }

    // Constructor completo
    public TurnoDTO(String id, String nombre, LocalTime horaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Override
    public String toString() {
        return "TurnoDTO {" +
                "ID='" + id + '\'' +
                ", Bloque='" + nombre + '\'' +
                ", Empieza a las=" + horaInicio +
                '}';
    }
}