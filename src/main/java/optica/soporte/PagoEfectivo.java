package main.java.optica.soporte;

public class PagoEfectivo implements PagoStrategy {

    private double montoRecibido;

    public PagoEfectivo(double montoRecibido) {
        setMontoRecibido(montoRecibido);
    }

    public double getMontoRecibido() {
        return montoRecibido;
    }

    public void setMontoRecibido(double montoRecibido) {
        if (Double.isNaN(montoRecibido)
                || Double.isInfinite(montoRecibido)) {

            throw new IllegalArgumentException(
                    "El monto recibido debe ser un número válido."
            );
        }

        if (montoRecibido <= 0) {
            throw new IllegalArgumentException(
                    "El monto recibido debe ser mayor que cero."
            );
        }

        this.montoRecibido = montoRecibido;
    }

    public double calcularVuelto(double montoPagar) {
        validarMonto(montoPagar);

        if (montoRecibido < montoPagar) {
            throw new IllegalStateException(
                    "El monto recibido es insuficiente para completar el pago."
            );
        }

        return montoRecibido - montoPagar;
    }

    @Override
    public String procesarPago(double monto) {
        validarMonto(monto);

        double vuelto = calcularVuelto(monto);

        return "Pago en efectivo procesado correctamente."
                + " | Total: S/ " + String.format("%.2f", monto)
                + " | Recibido: S/ "
                + String.format("%.2f", montoRecibido)
                + " | Vuelto: S/ "
                + String.format("%.2f", vuelto);
    }

    @Override
    public String obtenerMetodoPago() {
        return "Efectivo";
    }

    @Override
    public String toString() {
        return "PagoEfectivo"
                + " | Monto recibido: S/ "
                + String.format("%.2f", montoRecibido);
    }
}