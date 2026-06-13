package main.java.optica.model;

import java.util.UUID;


public class LenteFactory {


    public static Lente crearLente(String gama, String marca) {

        String idGenerado = "LEN-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        if (gama.equalsIgnoreCase("ECONOMICA")) {
            return new LenteBuilder()
                    .setId(idGenerado)
                    .setMarca(marca)
                    .setMaterial("Resina Índice Estándar 1.56")
                    .setTipoDiseño("Monofocal")
                    .setTratamiento("Antireflex Básico")
                    .setPrecioBase(60.00) // S/. 60.00
                    .setStock(20)
                    .build();

        } else if (gama.equalsIgnoreCase("ANTI_BLUE")) {
            return new LenteBuilder()
                    .setId(idGenerado)
                    .setMarca(marca)
                    .setMaterial("Policarbonato (Alto Impacto)")
                    .setTipoDiseño("Monofocal")
                    .setTratamiento("Blue Defense + Filtro UV400")
                    .setPrecioBase(150.00) // S/. 150.00
                    .setStock(35)
                    .build();

        } else if (gama.equalsIgnoreCase("PREMIUM_HI")) {
            return new LenteBuilder()
                    .setId(idGenerado)
                    .setMarca(marca)
                    .setMaterial("Resina Alto Índice 1.67 (Ultra Delgado)")
                    .setTipoDiseño("Progresivo Digital")
                    .setTratamiento("Crizal Sapphire (Antirrayas y Antireflejo Superior)")
                    .setPrecioBase(450.00) // S/. 450.00
                    .setStock(10)
                    .build();
        }

        // Opción de control por defecto
        return new LenteBuilder()
                .setId(idGenerado)
                .setMarca("Genérico")
                .setMaterial("Resina")
                .setTipoDiseño("Monofocal")
                .setTratamiento("Ninguno")
                .setPrecioBase(40.00)
                .setStock(5)
                .build();
    }
}