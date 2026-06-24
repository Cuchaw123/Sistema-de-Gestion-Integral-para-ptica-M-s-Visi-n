package main.java.optica.soporte;

import main.java.optica.model.Auditoria;

import java.util.ArrayList;
import java.util.List;

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

    public int totalRegistros() {
        return registros.size();
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