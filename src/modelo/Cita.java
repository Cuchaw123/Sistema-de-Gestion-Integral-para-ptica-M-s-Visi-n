package modelo;

public class Cita {
    private Paciente paciente;
    private Doctor doctor;
    private String fecha;
    private String hora;

    public Cita(Paciente paciente,Doctor doctor,String fecha,String hora){
        this.paciente=paciente;
        this.doctor=doctor;
        this.fecha=fecha;
        this.hora=hora;
    }

    @Override
    public String toString(){
        return "\n--CITA MEDICA--" +
                "\n" + paciente +
                "\n" + doctor +
                "\nFecha:" + fecha +
                "\nHora:" + hora;
    }
}
