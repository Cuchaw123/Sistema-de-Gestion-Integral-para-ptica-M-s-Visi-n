package main.java.optica.soporte;

/**
 * Interfaz del patrón Strategy.
 * Define la operación que deben realizar todos los métodos de pago.
 */
public interface PagoStrategy {

    /**
     * Procesa el pago de una venta.
     *
     * @param monto importe total que debe pagar el cliente
     * @return mensaje con el resultado de la operación
     */
    String procesarPago(double monto);

    /**
     * Devuelve el nombre del método de pago utilizado.
     */
    String obtenerMetodoPago();

    /** * Valida que el monto recibido sea correcto. */

    default void validarMonto(double monto) {
        if (Double.isNaN(monto) || Double.isInfinite(monto)) {
            throw new IllegalArgumentException(
                    "El monto debe ser un número válido."
            );
        }

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto del pago debe ser mayor que cero."
            );
        }
    }
}

