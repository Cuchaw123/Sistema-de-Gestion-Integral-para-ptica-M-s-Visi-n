package main.java.optica.soporte;

import main.java.optica.model.Auditoria;

import java.util.UUID;

public class OperacionAuditableProxy implements OperacionAuditable {

    private final OperacionAuditable operacionReal;
    private final BitacoraSistema bitacora;

    public OperacionAuditableProxy(
            OperacionAuditable operacionReal
    ) {
        if (operacionReal == null) {
            throw new IllegalArgumentException(
                    "La operación real no puede ser nula."
            );
        }

        this.operacionReal = operacionReal;
        this.bitacora = BitacoraSistema.getInstancia();
    }

    @Override
    public String ejecutar() {
        String resultado;

        try {
            resultado = operacionReal.ejecutar();

            registrarAuditoria(
                    operacionReal.obtenerDescripcion()
                            + " | Resultado: operación exitosa"
            );

            return resultado;

        } catch (RuntimeException excepcion) {
            registrarAuditoria(
                    operacionReal.obtenerDescripcion()
                            + " | Resultado: operación fallida"
                            + " | Motivo: " + excepcion.getMessage()
            );

            throw excepcion;
        }
    }

    @Override
    public String obtenerUsuario() {
        return operacionReal.obtenerUsuario();
    }

    @Override
    public String obtenerModulo() {
        return operacionReal.obtenerModulo();
    }

    @Override
    public String obtenerDescripcion() {
        return operacionReal.obtenerDescripcion();
    }

    private void registrarAuditoria(String descripcion) {
        Auditoria auditoria = new Auditoria(
                generarIdAuditoria(),
                obtenerUsuario(),
                descripcion,
                obtenerModulo()
        );

        bitacora.registrar(auditoria);
    }

    private String generarIdAuditoria() {
        return "AUD-"
                + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();
    }
}

