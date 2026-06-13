package main.java.optica.model;


public class CategoriaFactory {



    public static Categoria crearCategoria(String tipo) {
        if (tipo == null) {
            return null;
        }

        // Se utiliza el CategoriaBuilder para inicializar cada objeto de forma fluida
        if (tipo.equalsIgnoreCase("SOL")) {
            return new CategoriaBuilder()
                    .setId("CAT-SOL")
                    .setNombre("Lentes de Sol")
                    .setDescripcion("Modelos con protección UV400 y lunas polarizadas")
                    .build();

        } else if (tipo.equalsIgnoreCase("CONTACTO")) {
            return new CategoriaBuilder()
                    .setId("CAT-CON")
                    .setNombre("Lentes de Contacto")
                    .setDescripcion("Lentes de contacto cosméticos y de medida (diarios/mensuales)")
                    .build();

        } else if (tipo.equalsIgnoreCase("MONTURA")) {
            return new CategoriaBuilder()
                    .setId("CAT-MON")
                    .setNombre("Monturas")
                    .setDescripcion("Marcos de acetato, metal y titanio para lunas correctivas")
                    .build();
        }

        // Opción por defecto para evitar valores nulos inesperados
        return new CategoriaBuilder()
                .setId("CAT-GEN")
                .setNombre("Otros / Genérico")
                .setDescripcion("Categoría general para productos complementarios")
                .build();
    }
}