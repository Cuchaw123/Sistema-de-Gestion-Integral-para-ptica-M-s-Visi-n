package main.java.optica.model;

import java.time.LocalDate;
import java.util.UUID;


public class RecetaFactory {


    public static Receta crearRecetaVacia(String pacienteId, String doctorId) {

        // Generamos un código único para la orden de laboratorio
        String idGenerado = "REC-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        return new RecetaBuilder()
                .setId(idGenerado)
                .setPacienteId(pacienteId)
                .setDoctorId(doctorId)
                .setOdEsfera(0.0)
                .setOdCilindro(0.0)
                .setOdEje(0)
                .setOdAdicion(0.0)
                .setOiEsfera(0.0)
                .setOiCilindro(0.0)
                .setOiEje(0)
                .setOiAdicion(0.0)
                .setDistanciaPupilar(60)     // Medida promedio base estándar
                .setAlturaCornea(0)
                .setTipoLunaRecomendada("Resina Estándar")
                .setFechaEmision(LocalDate.now())
                .build();
    }
}