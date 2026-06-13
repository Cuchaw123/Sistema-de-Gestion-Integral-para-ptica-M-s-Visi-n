package main.java.optica.model;

import java.util.UUID;


public class DescuentoFactory {


    public static Descuento crearDescuento(String campaña) {

        // Generamos un código único para el descuento
        String idGenerado = "DESC-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        if (campaña.equalsIgnoreCase("BIENVENIDA")) {
            return new DescuentoBuilder()
                    .setId("BIENVENIDA10")
                    .setNombre("Descuento de Bienvenida para Nuevos Clientes")
                    .setTipo("PORCENTAJE")
                    .setValor(10.0) // 10% de descuento
                    .setActivo(true)
                    .build();

        } else if (campaña.equalsIgnoreCase("LIQUIDACION")) {
            return new DescuentoBuilder()
                    .setId(idGenerado)
                    .setNombre("Liquidación de Temporada - Monturas Seleccionadas")
                    .setTipo("PORCENTAJE")
                    .setValor(30.0) // 30% de descuento
                    .setActivo(true)
                    .build();

        } else if (campaña.equalsIgnoreCase("CUPON")) {
            return new DescuentoBuilder()
                    .setId("CUPON20")
                    .setNombre("Cupón Fijo de Descuento por Convenio")
                    .setTipo("MONTO_FIJO")
                    .setValor(20.0) // S/. 20.00 de rebaja directa
                    .setActivo(true)
                    .build();
        }

        // Opción por defecto: Descuento general mínimo o de control
        return new DescuentoBuilder()
                .setId("DSCTO-GEN")
                .setNombre("Descuento General de Cortesía")
                .setTipo("MONTO_FIJO")
                .setValor(0.0)
                .setActivo(false)
                .build();
    }
}