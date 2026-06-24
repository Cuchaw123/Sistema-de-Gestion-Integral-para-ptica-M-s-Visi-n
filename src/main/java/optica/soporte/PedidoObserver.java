package main.java.optica.soporte;

/**
 * Patrón de diseño OBSERVER (interfaz Observador).
 * La implementan las clases que deben ser notificadas cuando
 * cambia el estado de un pedido óptico.
 */
public interface PedidoObserver {
    void actualizar(String idPedido, String nuevoEstado);
}