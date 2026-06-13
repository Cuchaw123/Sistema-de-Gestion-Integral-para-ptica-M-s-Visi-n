package main.java.optica.model;

import java.util.UUID;


public class ProductoFactory {


    public static Producto crearAccesorio(String tipo, String marca) {

        // Generamos un identificador único para el SKU del accesorio
        String idGenerado = "ACC-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        if (tipo.equalsIgnoreCase("LIQUIDO")) {
            return new ProductoBuilder()
                    .setId(idGenerado)
                    .setNombre("Líquido Limpiador " + marca)
                    .setCategoria("Limpieza")
                    .setDescripcion("Spray limpiador con fórmula antiempañante para todo tipo de lunas.")
                    .setPrecio(15.00) // S/. 15.00
                    .setStock(50)
                    .build();

        } else if (tipo.equalsIgnoreCase("ESTUCHE")) {
            return new ProductoBuilder()
                    .setId(idGenerado)
                    .setNombre("Estuche Rígido " + marca)
                    .setCategoria("Accesorios")
                    .setDescripcion("Protector con estructura reforzada e interior de microfibra suave.")
                    .setPrecio(25.00) // S/. 25.00
                    .setStock(30)
                    .build();

        } else if (tipo.equalsIgnoreCase("CORDON")) {
            return new ProductoBuilder()
                    .setId(idGenerado)
                    .setNombre("Cordón Sujetador " + marca)
                    .setCategoria("Accesorios")
                    .setDescripcion("Cordón elástico de alta resistencia ideal para deportistas.")
                    .setPrecio(10.00) // S/. 10.00
                    .setStock(40)
                    .build();
        }

        // Producto genérico de control por defecto
        return new ProductoBuilder()
                .setId(idGenerado)
                .setNombre("Accesorio Genérico")
                .setCategoria("Varios")
                .setDescripcion("Artículo complementario para lentes.")
                .setPrecio(5.00)
                .setStock(10)
                .build();
    }
}