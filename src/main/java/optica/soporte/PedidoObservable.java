package main.java.optica.soporte;

import java.util.ArrayList;
import java.util.List;

/**
 * Patrón de diseño OBSERVER (Sujeto / Observable).
 * Mantiene la lista de observadores y los notifica automáticamente
 * cada vez que cambia el estado del pedido óptico.
 */
public class PedidoObservable {
    private final String idPedido;
    private String estado;
    private final List<PedidoObserver> observadores = new ArrayList<>();

    public PedidoObservable(String idPedido) {
        this.idPedido = idPedido;
        this.estado = "REGISTRADO";
    }

    public void agregarObservador(PedidoObserver o) {
        observadores.add(o);
    }

    public void quitarObservador(PedidoObserver o) {
        observadores.remove(o);
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (PedidoObserver o : observadores) {
            o.actualizar(idPedido, estado);
        }
    }

    public String getEstado() {
        return estado;
    }
}