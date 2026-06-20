package main.java.optica.controller;

import main.java.optica.soporte.PagoStrategy;

public class PagoController {

    private PagoStrategy estrategiaPago;

    public PagoController() {
    }

    public PagoController(PagoStrategy estrategiaPago) {
        setEstrategiaPago(estrategiaPago);
    }

    public PagoStrategy getEstrategiaPago() {
        return estrategiaPago;
    }

    public void setEstrategiaPago(PagoStrategy estrategiaPago) {
        if (estrategiaPago == null) {
            throw new IllegalArgumentException(
                    "La estrategia de pago no puede ser nula."
            );
        }

        this.estrategiaPago = estrategiaPago;
    }

    public String procesarPago(double monto) {
        if (estrategiaPago == null) {
            throw new IllegalStateException(
                    "Debe seleccionar un método de pago."
            );
        }

        return estrategiaPago.procesarPago(monto);
    }

    public String obtenerMetodoSeleccionado() {
        if (estrategiaPago == null) {
            return "Sin método de pago seleccionado";
        }

        return estrategiaPago.obtenerMetodoPago();
    }

    public boolean tieneEstrategiaSeleccionada() {
        return estrategiaPago != null;
    }

    public void limpiarEstrategia() {
        estrategiaPago = null;
    }
}

