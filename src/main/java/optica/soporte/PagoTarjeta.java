package main.java.optica.soporte;

public class PagoTarjeta implements PagoStrategy {

    private String tipoTarjeta;
    private String ultimosCuatroDigitos;
    private String codigoOperacion;

    public PagoTarjeta(
            String tipoTarjeta,
            String ultimosCuatroDigitos,
            String codigoOperacion
    ) {
        setTipoTarjeta(tipoTarjeta);
        setUltimosCuatroDigitos(ultimosCuatroDigitos);
        setCodigoOperacion(codigoOperacion);
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        if (tipoTarjeta == null || tipoTarjeta.isBlank()) {
            throw new IllegalArgumentException(
                    "El tipo de tarjeta es obligatorio."
            );
        }

        this.tipoTarjeta = tipoTarjeta.trim();
    }

    public String getUltimosCuatroDigitos() {
        return ultimosCuatroDigitos;
    }

    public void setUltimosCuatroDigitos(
            String ultimosCuatroDigitos
    ) {
        if (ultimosCuatroDigitos == null
                || !ultimosCuatroDigitos.matches("\\d{4}")) {

            throw new IllegalArgumentException(
                    "Debe ingresar los últimos 4 dígitos de la tarjeta."
            );
        }

        this.ultimosCuatroDigitos = ultimosCuatroDigitos;
    }

    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(String codigoOperacion) {
        if (codigoOperacion == null || codigoOperacion.isBlank()) {
            throw new IllegalArgumentException(
                    "El código de operación es obligatorio."
            );
        }

        this.codigoOperacion = codigoOperacion.trim();
    }

    @Override
    public String procesarPago(double monto) {
        validarMonto(monto);

        return "Pago con tarjeta procesado correctamente."
                + " | Total: S/ "
                + String.format("%.2f", monto)
                + " | Tipo: " + tipoTarjeta
                + " | Tarjeta terminada en: "
                + ultimosCuatroDigitos
                + " | Código de operación: "
                + codigoOperacion;
    }

    @Override
    public String obtenerMetodoPago() {
        return "Tarjeta";
    }

    @Override
    public String toString() {
        return "PagoTarjeta"
                + " | Tipo: " + tipoTarjeta
                + " | Terminación: " + ultimosCuatroDigitos
                + " | Operación: " + codigoOperacion;
    }
}