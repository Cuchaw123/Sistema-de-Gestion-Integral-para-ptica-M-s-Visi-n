package main.java.optica.soporte;

import main.java.optica.model.Auditoria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Patrón de diseño SINGLETON.
 * Mantiene una única instancia de la bitácora de auditoría del sistema,
 * almacenando de forma centralizada todos los registros de Auditoria.
 */
public class BitacoraSistema {

    private static BitacoraSistema instancia;   // Única instancia
    private final List<Auditoria> registros;

    private BitacoraSistema() {                  // Constructor privado
        registros = new ArrayList<>();
    }

    public static synchronized BitacoraSistema getInstancia() {
        if (instancia == null) {
            instancia = new BitacoraSistema();
        }
        return instancia;
    }

    public void registrar(Auditoria auditoria) {
        if (auditoria == null) {
            throw new IllegalArgumentException(
                    "La auditoría a registrar no puede ser nula."
            );
        }
        registros.add(auditoria);
    }

    public List<Auditoria> obtenerRegistros() {
        return new ArrayList<>(registros); // Copia defensiva
    }

    public List<Auditoria> buscarPorModulo(String modulo) {
        if (modulo == null || modulo.isBlank()) {
            throw new IllegalArgumentException(
                    "El módulo a buscar es obligatorio."
            );
        }
        return registros.stream()
                .filter(a -> a.perteneceAlModulo(modulo))
                .collect(Collectors.toList());
    }

    public List<Auditoria> buscarPorUsuario(String usuario) {
        if (usuario == null || usuario.isBlank()) {
            throw new IllegalArgumentException(
                    "El usuario a buscar es obligatorio."
            );
        }
        return registros.stream()
                .filter(a -> a.fueRealizadaPor(usuario))
                .collect(Collectors.toList());
    }

    public int obtenerCantidadRegistros() {
        return registros.size();
    }

    public boolean tieneRegistros() {
        return !registros.isEmpty();
    }

    public void limpiar() {
        registros.clear();
    }

    public void imprimirHistorial() {
        if (registros.isEmpty()) {
            System.out.println("No hay registros de auditoría.");
            return;
        }
        for (Auditoria a : registros) {
            System.out.println(a);
        }
    }
}