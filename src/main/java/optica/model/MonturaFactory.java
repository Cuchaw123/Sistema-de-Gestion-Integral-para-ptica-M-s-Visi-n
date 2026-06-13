package main.java.optica.model;

import java.util.UUID;


public class MonturaFactory {


    public static Montura crearMontura(String estilo, String marca, String color) {

        // Generamos un código correlativo único para el código de barras
        String idGenerado = "MON-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        if (estilo.equalsIgnoreCase("DEPORTIVA")) {
            return new MonturaBuilder()
                    .setId(idGenerado)
                    .setMarca(marca)
                    .setModelo("Sport-X")
                    .setMaterial("TR90 (Polímero Ultra Flexible)")
                    .setTipoAro("Completo")
                    .setForma("Envolvente / Aerodinámica")
                    .setColor(color)
                    .setPrecio(290.00) // S/. 290.00
                    .setStock(12)
                    .build();

        } else if (estilo.equalsIgnoreCase("URBANA_MODA")) {
            return new MonturaBuilder()
                    .setId(idGenerado)
                    .setMarca(marca)
                    .setModelo("Trend-Classic")
                    .setMaterial("Acetato Italiano")
                    .setTipoAro("Completo")
                    .setForma("Cat Eye / Rectangular")
                    .setColor(color)
                    .setPrecio(350.00) // S/. 350.00
                    .setStock(15)
                    .build();

        } else if (estilo.equalsIgnoreCase("ECONOMICA")) {
            return new MonturaBuilder()
                    .setId(idGenerado)
                    .setMarca(marca)
                    .setModelo("Basic-Line")
                    .setMaterial("Monel (Aleación de Metal)")
                    .setTipoAro("Semi-al aire")
                    .setForma("Ovalada / Ejecutiva")
                    .setColor(color)
                    .setPrecio(110.00) // S/. 110.00
                    .setStock(25)
                    .build();
        }

        // Opción genérica de control por defecto
        return new MonturaBuilder()
                .setId(idGenerado)
                .setMarca("Genérica")
                .setModelo("Standar")
                .setMaterial("Plástico")
                .setTipoAro("Completo")
                .setForma("Rectangular")
                .setColor(color)
                .setPrecio(70.00)
                .setStock(5)
                .build();
    }
}