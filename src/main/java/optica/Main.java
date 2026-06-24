package main.java.optica;

import main.java.optica.model.Accesorio;
import main.java.optica.model.AccesorioBuilder;
import main.java.optica.model.AccesorioFactory;
import main.java.optica.model.ProductoOptico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Demo de consola :
 */





















public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================================");
        System.out.println("   SISTEMA DE GESTION INTEGRAL - OPTICA MAS VISION");
        System.out.println("   Demo de la capa de modelo (Avance)");
        System.out.println("==========================================================\n");

        // ---------- 1) PATRON BUILDER ----------
        System.out.println(">> [1] Patron Builder: construccion paso a paso de accesorios");
        Accesorio estuche = new AccesorioBuilder()
                .setId("ACC-100")
                .setNombre("Estuche Rigido Deluxe")
                .setPrecio(29.90)
                .build();

        Accesorio panoPremium = new AccesorioBuilder()
                .setId("ACC-101")
                .setNombre("Pano Microfibra Premium")
                .setPrecio(9.50)
                .build();
        System.out.println("   Construidos con Builder: " + estuche.getNombre()
                + " y " + panoPremium.getNombre() + "\n");

        // ---------- 2) PATRON FACTORY ----------
        System.out.println(">> [2] Patron Factory: creacion por tipo");
        Accesorio liquido = AccesorioFactory.crearAccesorio("LIQUIDO");
        Accesorio cordon  = AccesorioFactory.crearAccesorio("CORDON");
        Accesorio generico = AccesorioFactory.crearAccesorio("DESCONOCIDO"); // cae al por defecto
        System.out.println("   Factory genero: " + liquido.getNombre() + ", "
                + cordon.getNombre() + ", " + generico.getNombre() + "\n");

        // ---------- Catalogo (polimorfismo via ProductoOptico) ----------
        List<ProductoOptico> catalogo = new ArrayList<>();
        catalogo.add(estuche);
        catalogo.add(panoPremium);
        catalogo.add(liquido);
        catalogo.add(cordon);
        catalogo.add(generico);

        System.out.println(">> Catalogo completo (polimorfismo: mostrarDetalles()):");
        catalogo.forEach(ProductoOptico::mostrarDetalles);
        System.out.println();

        // ---------- 3) STREAMS + LAMBDAS ----------
        System.out.println(">> [3] Programacion funcional: streams y lambdas\n");

        // a) Filtrar productos con precio mayor a S/.10
        System.out.println("   a) Productos con precio > S/.10:");
        catalogo.stream()
                .filter(p -> p.getPrecio() > 10.0)
                .forEach(p -> System.out.println("      - " + p.getNombre()
                        + " (S/." + p.getPrecio() + ")"));

        // b) Ordenar por precio ascendente y mostrar solo nombres
        System.out.println("\n   b) Catalogo ordenado por precio (asc):");
        catalogo.stream()
                .sorted(Comparator.comparingDouble(ProductoOptico::getPrecio))
                .map(ProductoOptico::getNombre)
                .forEach(nombre -> System.out.println("      - " + nombre));

        // c) Total del catalogo (reduce/sum)
        double total = catalogo.stream()
                .mapToDouble(ProductoOptico::getPrecio)
                .sum();
        System.out.printf("%n   c) Valor total del catalogo: S/.%.2f%n", total);

        // d) Conteo de productos "economicos" (<= S/.10)
        long economicos = catalogo.stream()
                .filter(p -> p.getPrecio() <= 10.0)
                .count();
        System.out.println("   d) Cantidad de productos economicos (<= S/.10): " + economicos);

        System.out.println("\n==========================================================");
        System.out.println("   Demo finalizada correctamente.");
        System.out.println("==========================================================");
    }
}