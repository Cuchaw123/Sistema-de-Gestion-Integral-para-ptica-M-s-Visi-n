package main.java.optica.view;

import main.java.optica.model.Producto;
import main.java.optica.model.Venta;
import main.java.optica.model.VentaFactory;
import main.java.optica.soporte.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Interfaz de consola del sistema Óptica Más Visión (capa View).
 * Integra el patrón Strategy (métodos de pago), el patrón Observer
 * (seguimiento de pedidos), las fábricas del modelo y programación
 * funcional con Streams.
 */
public class MenuPrincipalView {

    private final Scanner sc = new Scanner(System.in);
    private final List<Producto> inventario = crearInventarioDemo();

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1 -> registrarVenta();
                case 2 -> procesarPago();
                case 3 -> seguimientoPedido();
                case 4 -> verStockBajo();
                case 0 -> System.out.println("\nSaliendo del sistema. Hasta pronto!");
                default -> System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n========= OPTICA MAS VISION =========");
        System.out.println("1. Registrar venta");
        System.out.println("2. Procesar pago");
        System.out.println("3. Seguimiento de pedido");
        System.out.println("4. Ver productos con stock bajo");
        System.out.println("0. Salir");
        System.out.println("=====================================");
    }

    // OPCION 1: usa Factory + Builder del modelo
    private void registrarVenta() {
        System.out.println("\n--- Registrar Venta ---");
        String paciente = leerTexto("ID del paciente: ");
        double monto = leerDouble("Monto total (S/): ");
        Venta venta = VentaFactory.crearVentaCompletada(paciente, "USR-001", "SEDE-LIMA", monto, 0.0);
        System.out.println("\nVenta registrada:");
        System.out.println(venta);
    }

    // OPCION 2: usa el patron STRATEGY (clases reales del soporte)
    private void procesarPago() {
        System.out.println("\n--- Procesar Pago ---");
        double monto = leerDouble("Monto a pagar (S/): ");
        System.out.println("Metodo de pago: 1) Efectivo  2) Tarjeta  3) Yape");
        int m = leerEntero("Elija metodo: ");

        PagoStrategy estrategia;
        switch (m) {
            case 1 -> {
                double recibido = leerDouble("Monto recibido (S/): ");
                estrategia = new PagoEfectivo(recibido);
            }
            case 2 -> estrategia = new PagoTarjeta("VISA", "1234", "OP-0001");
            case 3 -> estrategia = new PagoYape("987654321", "YPE-0001");
            default -> {
                System.out.println("Metodo invalido.");
                return;
            }
        }

        try {
            String resultado = estrategia.procesarPago(monto);
            System.out.println("\nMetodo: " + estrategia.obtenerMetodoPago());
            System.out.println(resultado);
        } catch (RuntimeException e) {
            System.out.println("Error al procesar el pago: " + e.getMessage());
        }
    }

    // OPCION 3: usa el patron OBSERVER
    private void seguimientoPedido() {
        System.out.println("\n--- Seguimiento de Pedido (Observer) ---");
        String idPedido = leerTexto("ID del pedido: ");
        String paciente = leerTexto("Nombre del paciente: ");

        PedidoObservable pedido = new PedidoObservable(idPedido);
        pedido.agregarObservador(new NotificadorPaciente(paciente));
        pedido.agregarObservador(new NotificadorOptometra("Dra. Ramirez"));

        System.out.println("\nActualizando estados del pedido:");
        pedido.cambiarEstado("EN LABORATORIO");
        pedido.cambiarEstado("LISTO PARA ENTREGA");
    }

    // OPCION 4: usa STREAMS + lambdas
    private void verStockBajo() {
        System.out.println("\n--- Productos con stock bajo (< 5) ---");
        inventario.stream()
                .filter(p -> p.getStock() < 5)
                .forEach(p -> System.out.println("   - " + p.getNombre()
                        + " (stock: " + p.getStock() + ")"));
    }

    private List<Producto> crearInventarioDemo() {
        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto("PR-1", "Liquido limpiador", "Limpieza", "Spray 60ml", 18.0, 3));
        lista.add(new Producto("PR-2", "Estuche rigido", "Accesorios", "Estuche premium", 25.0, 12));
        lista.add(new Producto("PR-3", "Pano microfibra", "Limpieza", "Pano antirayas", 8.0, 2));
        return lista;
    }

    // ---------- utilidades de lectura ----------
    private int leerEntero(String msg) {
        System.out.print(msg);
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un numero valido: ");
            sc.next();
        }
        int v = sc.nextInt();
        sc.nextLine();
        return v;
    }

    private double leerDouble(String msg) {
        System.out.print(msg);
        while (!sc.hasNextDouble()) {
            System.out.print("Ingrese un monto valido: ");
            sc.next();
        }
        double v = sc.nextDouble();
        sc.nextLine();
        return v;
    }

    private String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
}