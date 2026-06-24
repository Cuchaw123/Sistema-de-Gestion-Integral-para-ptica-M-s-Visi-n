package main.java.optica.model;

public interface ObservadorPedido {

    /**
     * Recibe la información del pedido actualizado.
     *
     * @param pedidoId identificador del pedido
     * @param estadoAnterior estado que tenía antes del cambio
     * @param estadoNuevo nuevo estado del pedido
     * @param mensaje descripción de la actualización
     */
    void actualizar(
            String pedidoId,
            EstadoPedido estadoAnterior,
            EstadoPedido estadoNuevo,
            String mensaje
    );
}

