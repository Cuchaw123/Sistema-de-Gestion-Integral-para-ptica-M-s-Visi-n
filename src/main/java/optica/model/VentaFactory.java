package main.java.optica.model;

import java.time.LocalDateTime;
import java.util.UUID;


public class VentaFactory {

    private static final double TASA_IGV = 0.18; // Constante del Impuesto General a las Ventas


    public static Venta crearVentaCompletada(String pacienteId, String usuarioId, String sedeId,
                                             double montoTotal, double descuento) {

        // Generamos un código de boleta electrónico único
        String idBoleta = "VTA-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        // Desglose matemático: Si el total ya incluye IGV, el subtotal base es Total / 1.18
        double subTotalBase = montoTotal / (1.0 + TASA_IGV);
        double igvCalculado = montoTotal - subTotalBase;

        return new VentaBuilder()
                .setId(idBoleta)
                .setPacienteId(pacienteId)
                .setUsuarioId(usuarioId)
                .setSedeId(sedeId)
                .setFechaHora(LocalDateTime.now())
                .setSubTotal(Math.round(subTotalBase * 100.0) / 100.0)
                .setDescuentoTotal(descuento)
                .setIgv(Math.round(igvCalculado * 100.0) / 100.0)
                .setTotal(montoTotal)
                .setEstado("COMPLETADA")
                .build();
    }
}