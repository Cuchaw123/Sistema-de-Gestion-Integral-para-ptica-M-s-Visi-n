package main.java.optica.soporte;

public class PagoYape implements PagoStrategy {

    private String numeroCelular;
    private String codigoOperacion;

    public PagoYape(
            String numeroCelular,
            String codigoOperacion
    ) {
        setNumeroCelular(numeroCelular);
        setCodigoOperacion(codigoOperacion);
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        if (numeroCelular == null
                || !numeroCelular.matches("\\d{9}")) {

            throw new IllegalArgumentException(
                    "El número asociado a Yape debe tener 9 dígitos."
            );
        }

        this.numeroCelular = numeroCelular;
    }

    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(String codigoOperacion) {
        if (codigoOperacion == null || codigoOperacion.isBlank()) {
            throw new IllegalArgumentException(
                    "El código de operación de Yape es obligatorio."
            );
        }

        this.codigoOperacion = codigoOperacion.trim();
    }

    @Override
    public String procesarPago(double monto) {
        validarMonto(monto);

        return "Pago mediante Yape procesado correctamente."
                + " | Total: S/ "
                + String.format("%.2f", monto)
                + " | Número asociado: "
                + ocultarNumeroCelular()
                + " | Código de operación: "
                + codigoOperacion;
    }

    @Override
    public String obtenerMetodoPago() {
        return "Yape";
    }

    public String ocultarNumeroCelular() {
        return "*****" + numeroCelular.substring(5);
    }

    @Override
    public String toString() {
        return "PagoYape"
                + " | Número asociado: "
                + ocultarNumeroCelular()
                + " | Operación: "
                + codigoOperacion;
    }
}
