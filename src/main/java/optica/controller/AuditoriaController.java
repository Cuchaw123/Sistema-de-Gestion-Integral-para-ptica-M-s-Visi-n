package main.java.optica.controller;

import main.java.optica.model.Auditoria;
import main.java.optica.soporte.BitacoraSistema;
import main.java.optica.soporte.OperacionAuditable;
import main.java.optica.soporte.OperacionAuditableProxy;

import java.util.List;

public class AuditoriaController {

    private final BitacoraSistema bitacora;

    public AuditoriaController() {
        this.bitacora = BitacoraSistema.getInstancia();
    }

    public String ejecutarOperacion(
            OperacionAuditable operacion
    ) {
        if (operacion == null) {
            throw new IllegalArgumentException(
                    "La operación no puede ser nula."
            );
        }

        OperacionAuditable proxy =
                new OperacionAuditableProxy(operacion);

        return proxy.ejecutar();
    }

    public void registrarOperacion(
            String id,
            String usuario,
            String operacion,
            String modulo
    ) {
        Auditoria auditoria = new Auditoria(
                id,
                usuario,
                operacion,
                modulo
        );

        bitacora.registrar(auditoria);
    }

    public List<Auditoria> listarRegistros() {
        return bitacora.obtenerRegistros();
    }

    public List<Auditoria> buscarPorModulo(
            String modulo
    ) {
        return bitacora.buscarPorModulo(modulo);
    }

    public List<Auditoria> buscarPorUsuario(
            String usuario
    ) {
        return bitacora.buscarPorUsuario(usuario);
    }

    public int obtenerCantidadRegistros() {
        return bitacora.obtenerCantidadRegistros();
    }

    public boolean tieneRegistros() {
        return bitacora.tieneRegistros();
    }

    public void limpiarBitacora() {
        bitacora.limpiar();
    }
}

