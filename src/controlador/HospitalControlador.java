package controlador;

import modelo.Cita;


import java.util.ArrayList;


public class HospitalControlador {
      private ArrayList<Cita>listaCitas;

      public HospitalControlador(){
          listaCitas = new ArrayList<>();
      }
      public void agregarCita(Cita cita){
          listaCitas.add(cita);
      }

      public void mostrarCitas(){
          if(listaCitas.isEmpty()){
              System.out.println("No hay citas registradas");
          }else{
              for (Cita c : listaCitas){
                  System.out.println(c);
              }
          }
      }

}
