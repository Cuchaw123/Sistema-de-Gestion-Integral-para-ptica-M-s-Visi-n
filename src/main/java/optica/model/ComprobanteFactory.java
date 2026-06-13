package main.java.optica.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Factory para la creación centralizada de Comprobantes de Pago.
 * Aplica el patrón Factory Method y realiza el desglose automático de impuestos.
 */
public class ComprobanteFactory {

    /**
     * Crea una Boleta o Factura desglosando los impuestos en base al monto total recibido.
     * @param tipo "BOLETA" o "FACTURA"
     * @param clienteId ID del cliente/paciente
     * @param montoTotal El monto total pagado por el cliente
     * @return Instancia de Comprobante configurada
     */
    public static Comprobante crearComprobante(String tipo, String clienteId, double montoTotal) {

        // Generamos un número correlativo simulado
        String correlativo = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        String idComprobante;

        // 1. Desglose matemático del IGV (18%)
        // Formula: Subtotal = Total / 1.18
        double subtotal = montoTotal / 1.18;
        // Formula: IGV = Total - Subtotal
        double igv = montoTotal - subtotal;

        // Redondeo simple a 2 decimales para evitar problemas de precisión flotante
        subtotal = Math.round(subtotal * 100.0) / 100.0;
        igv = Math.round(igv * 100.0) / 100.0;

        // 2. Definición de serie según el tipo de documento
        if (tipo.equalsIgnoreCase("FACTURA")) {
            idComprobante = "F001-" + correlativo;
            return new ComprobanteBuilder()
                    .setId(idComprobante)
                    .setTipo("FACTURA")
                    .setFechaEmision(LocalDateTime.now())
                    .setClienteId(clienteId)
                    .setSubtotal(subtotal)
                    .setIgv(igv)
                    .setTotal(montoTotal)
                    .build();
        }

        // Por defecto genera una Boleta de venta
        idComprobante = "B001-" + correlativo;
        return new ComprobanteBuilder()
                .setId(idComprobante)
                .setTipo("BOLETA")
                .setFechaEmision(LocalDateTime.now())
                .setClienteId(clienteId)
                .setSubtotal(subtotal)
                .setIgv(igv)
                .setTotal(montoTotal)
                .build();
    }
}