package modelo;

public class Paciente {


    private String nombre;
    private int edad;
    private String dni;


    public Paciente(String nombre, int edad,String dni){
    this.nombre=nombre;
    this.edad=edad;
    this.dni=dni;
    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public String getDni(){
        return dni;
    }
    @Override
    public String toString(){
        return "Paciente:"+nombre+
                " | Edad: "+edad+
                " | DNI: "+dni;
    }
}
