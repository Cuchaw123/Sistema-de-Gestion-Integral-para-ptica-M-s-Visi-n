package main.java.optica.view;

import main.java.optica.model.CitaOptometrica;
import main.java.optica.model.Producto;
import main.java.optica.model.Venta;
import main.java.optica.model.VentaFactory;
import main.java.optica.soporte.CitaOptometricaRepositoryMySQL;
import main.java.optica.soporte.NotificadorOptometra;
import main.java.optica.soporte.NotificadorPaciente;
import main.java.optica.soporte.OptometristaRepositoryMySQL;
import main.java.optica.soporte.PagoEfectivo;
import main.java.optica.soporte.PagoStrategy;
import main.java.optica.soporte.PagoTarjeta;
import main.java.optica.soporte.PagoYape;
import main.java.optica.soporte.PedidoObservable;
import main.java.optica.soporte.ProductoRepositoryMySQL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipalView {

    private final Scanner sc = new Scanner(System.in);

    private ProductoRepositoryMySQL productoRepo;
    private OptometristaRepositoryMySQL optometristaRepo;
    private CitaOptometricaRepositoryMySQL citaRepo;

    private boolean conectado;

    public void iniciar() {
        conectarMySQL();

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> registrarVenta();
                case 2 -> procesarPago();
                case 3 -> seguimientoPedido();
                case 4 -> verStockBajo();
                case 5 -> registrarProducto();
                case 6 -> listarProductos();
                case 7 -> aumentarStock();
                case 8 -> disminuirStock();
                case 9 -> registrarCita();
                case 10 -> listarCitas();
                case 11 -> conectarMySQL();
                case 0 -> System.out.println(
                        "Saliendo del sistema..."
                );
                default -> System.out.println(
                        "Opcion incorrecta."
                );
            }

        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println(
                "\n======= OPTICA MAS VISION ======="
        );

        System.out.println("1. Registrar venta");
        System.out.println("2. Procesar pago");
        System.out.println("3. Seguimiento de pedido");
        System.out.println("4. Ver productos con stock bajo");
        System.out.println("5. Registrar producto");
        System.out.println("6. Listar productos");
        System.out.println("7. Aumentar stock");
        System.out.println("8. Disminuir stock");
        System.out.println("9. Registrar cita optometrica");
        System.out.println("10. Listar citas optometricas");
        System.out.println("11. Reconectar MySQL");
        System.out.println("0. Salir");

        System.out.println(
                "MySQL: "
                        + (conectado
                        ? "CONECTADO"
                        : "DESCONECTADO")
        );

        System.out.println(
                "================================="
        );
    }

    private void conectarMySQL() {
        String url =
                "jdbc:mysql://localhost:3306/optica_mas_vision"
                        + "?useSSL=false"
                        + "&allowPublicKeyRetrieval=true";

        String clave =
                leerTexto("Contraseña de MySQL: ");

        try {
            productoRepo =
                    new ProductoRepositoryMySQL(
                            url,
                            "root",
                            clave
                    );

            optometristaRepo =
                    new OptometristaRepositoryMySQL(
                            url,
                            "root",
                            clave
                    );

            citaRepo =
                    new CitaOptometricaRepositoryMySQL(
                            url,
                            "root",
                            clave
                    );

            productoRepo.listarTodos();
            optometristaRepo.listarTodos();
            citaRepo.listarTodas();

            conectado = true;

            System.out.println(
                    "Conexion correcta con MySQL."
            );

        } catch (RuntimeException e) {
            conectado = false;

            System.out.println(
                    "No se pudo conectar con MySQL."
            );

            System.out.println(
                    "Detalle: " + e.getMessage()
            );
        }
    }

    // OPCION 1
    private void registrarVenta() {
        String paciente =
                leerTexto("ID del paciente: ");

        double monto =
                leerDouble("Monto total: ");

        Venta venta =
                VentaFactory.crearVentaCompletada(
                        paciente,
                        "USR-001",
                        "SEDE-LIMA",
                        monto,
                        0
                );

        System.out.println(
                "\nVenta registrada correctamente:"
        );

        System.out.println(venta);
    }

    // OPCION 2
    private void procesarPago() {
        double monto =
                leerDouble("Monto a pagar: ");

        System.out.println(
                "1. Efectivo | 2. Tarjeta | 3. Yape"
        );

        int metodo =
                leerEntero("Metodo: ");

        PagoStrategy pago;

        switch (metodo) {
            case 1 -> pago =
                    new PagoEfectivo(
                            leerDouble("Monto recibido: ")
                    );

            case 2 -> pago =
                    new PagoTarjeta(
                            "VISA",
                            "1234",
                            "OP-001"
                    );

            case 3 -> pago =
                    new PagoYape(
                            "987654321",
                            "YAPE-001"
                    );

            default -> {
                System.out.println(
                        "Metodo incorrecto."
                );

                return;
            }
        }

        try {
            System.out.println(
                    pago.procesarPago(monto)
            );

        } catch (RuntimeException e) {
            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // OPCION 3
    private void seguimientoPedido() {
        String id =
                leerTexto("ID del pedido: ");

        String paciente =
                leerTexto("Nombre del paciente: ");

        PedidoObservable pedido =
                new PedidoObservable(id);

        pedido.agregarObservador(
                new NotificadorPaciente(paciente)
        );

        pedido.agregarObservador(
                new NotificadorOptometra(
                        "Dra. Ramirez"
                )
        );

        pedido.cambiarEstado(
                "EN LABORATORIO"
        );

        pedido.cambiarEstado(
                "LISTO PARA ENTREGA"
        );
    }

    // OPCION 4
    private void verStockBajo() {
        if (!validarConexion()) {
            return;
        }

        try {
            List<Producto> productos =
                    productoRepo.listarStockBajo(5);

            if (productos.isEmpty()) {
                System.out.println(
                        "No hay productos con stock bajo."
                );

                return;
            }

            System.out.println(
                    "\n--- PRODUCTOS CON STOCK BAJO ---"
            );

            productos.forEach(
                    System.out::println
            );

        } catch (RuntimeException e) {
            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // OPCION 5
    private void registrarProducto() {
        if (!validarConexion()) {
            return;
        }

        try {
            Producto producto =
                    new Producto(
                            leerTexto("ID: "),
                            leerTexto("Nombre: "),
                            leerTexto("Categoria: "),
                            leerTexto("Descripcion: "),
                            leerDouble("Precio: "),
                            leerEntero("Stock inicial: ")
                    );

            productoRepo.guardar(producto);

            System.out.println(
                    "Producto guardado correctamente."
            );

        } catch (RuntimeException e) {
            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // OPCION 6
    private void listarProductos() {
        if (!validarConexion()) {
            return;
        }

        try {
            List<Producto> productos =
                    productoRepo.listarTodos();

            if (productos.isEmpty()) {
                System.out.println(
                        "No existen productos registrados."
                );

                return;
            }

            System.out.println(
                    "\n--- INVENTARIO DE PRODUCTOS ---"
            );

            productos.forEach(
                    System.out::println
            );

            System.out.println(
                    "\nTotal de productos: "
                            + productos.size()
            );

        } catch (RuntimeException e) {
            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // OPCION 7
    private void aumentarStock() {
        if (!validarConexion()) {
            return;
        }

        String id =
                leerTexto("ID del producto: ");

        int cantidad =
                leerEntero(
                        "Cantidad que ingresara: "
                );

        try {
            productoRepo.aumentarStock(
                    id,
                    cantidad
            );

            System.out.println(
                    "Stock aumentado correctamente."
            );

        } catch (RuntimeException e) {
            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // OPCION 8
    private void disminuirStock() {
        if (!validarConexion()) {
            return;
        }

        String id =
                leerTexto("ID del producto: ");

        int cantidad =
                leerEntero(
                        "Cantidad que saldra: "
                );

        try {
            productoRepo.disminuirStock(
                    id,
                    cantidad
            );

            System.out.println(
                    "Stock disminuido correctamente."
            );

        } catch (RuntimeException e) {
            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // OPCION 9
    private void registrarCita() {
        if (!validarConexion()) {
            return;
        }

        try {
            System.out.println(
                    "\n--- OPTOMETRISTAS DISPONIBLES ---"
            );

            optometristaRepo.listarTodos()
                    .forEach(optometrista ->
                            System.out.println(
                                    optometrista.getId()
                                            + " - "
                                            + optometrista.getNombre()
                                            + ""
                                            + optometrista.getApellido()
                            )
                    );

            String id =
                    leerTexto("ID de la cita: ");

            String pacienteId =
                    leerTexto("ID del paciente: ");

            String optometristaId =
                    leerTexto(
                            "ID del optometrista: "
                    );

            if (optometristaRepo
                    .buscarPorId(optometristaId)
                    .isEmpty()) {

                System.out.println(
                        "No existe un optometrista con ese ID."
                );

                return;
            }

            String fechaTexto =
                    leerTexto(
                            "Fecha (dd/MM/yyyy HH:mm): "
                    );

            DateTimeFormatter formato =
                    DateTimeFormatter.ofPattern(
                            "dd/MM/yyyy HH:mm"
                    );

            LocalDateTime fecha =
                    LocalDateTime.parse(
                            fechaTexto,
                            formato
                    );

            String motivo =
                    leerTexto(
                            "Motivo de la cita: "
                    );

            CitaOptometrica cita =
                    new CitaOptometrica(
                            id,
                            pacienteId,
                            optometristaId,
                            fecha,
                            motivo,
                            "PENDIENTE"
                    );

            citaRepo.guardar(cita);

            System.out.println(
                    "Cita guardada correctamente."
            );

        } catch (DateTimeParseException e) {
            System.out.println(
                    "Formato de fecha incorrecto."
            );

            System.out.println(
                    "Ejemplo: 30/06/2026 15:30"
            );

        } catch (RuntimeException e) {
            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // OPCION 10
    private void listarCitas() {
        if (!validarConexion()) {
            return;
        }

        try {
            List<CitaOptometrica> citas =
                    citaRepo.listarTodas();

            if (citas.isEmpty()) {
                System.out.println(
                        "No existen citas registradas."
                );

                return;
            }

            System.out.println(
                    "\n--- CITAS OPTOMETRICAS ---"
            );

            citas.forEach(
                    System.out::println
            );

            System.out.println(
                    "\nTotal de citas: "
                            + citas.size()
            );

        } catch (RuntimeException e) {
            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    private boolean validarConexion() {
        if (!conectado) {
            System.out.println(
                    "Primero debe conectarse a MySQL."
            );

            return false;
        }

        return true;
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(
                        leerTexto(mensaje)
                );

            } catch (NumberFormatException e) {
                System.out.println(
                        "Ingrese un numero entero valido."
                );
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(
                        leerTexto(mensaje)
                );

            } catch (NumberFormatException e) {
                System.out.println(
                        "Ingrese un numero valido."
                );
            }
        }
    }
}
