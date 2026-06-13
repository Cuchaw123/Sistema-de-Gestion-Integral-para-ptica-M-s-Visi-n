package main.java.optica.model;

import java.time.LocalDateTime;
import java.util.UUID;


public class PagoFactory {


    public static Pago procesarPagoRapido(String canal, String ventaId, double total, double recibido) {

        // Generamos un código de operación único para el arqueo de caja
        String idGenerado = "OP-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        if (canal.equalsIgnoreCase("DIGITAL")) {
            // Pagos por Yape/Plin son por el monto exacto, no generan vuelto físico
            return new PagoBuilder()
                    .setId(idGenerado)
                    .setVentaId(ventaId)
                    .setMetodoPago("BILLETERA_DIGITAL_YAPE_PLIN")
                    .setMontoTotal(total)
                    .setMontoRecibido(total) // Monto exacto enviado por transferencia
                    .setFechaPago(LocalDateTime.now())
                    .build();

        } else if (canal.equalsIgnoreCase("TARJETA")) {
            // Pagos con POS (Débito/Crédito) procesan la cantidad exacta cobrada
            return new PagoBuilder()
                    .setId(idGenerado)
                    .setVentaId(ventaId)
                    .setMetodoPago("TARJETA_POS")
                    .setMontoTotal(total)
                    .setMontoRecibido(total)
                    .setFechaPago(LocalDateTime.now())
                    .build();
        }

        // Por defecto: Pago en Efectivo (Cash con cálculo de vuelto regular)
        return new PagoBuilder()
                .setId(idGenerado)
                .setVentaId(ventaId)
                .setMetodoPago("EFECTIVO_SOLES")
                .setMontoTotal(total)
                .setMontoRecibido(recibido)
                .setFechaPago(LocalDateTime.now())
                .build();
    }
}