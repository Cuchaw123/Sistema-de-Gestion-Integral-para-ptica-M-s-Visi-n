package main.java.optica.model;

/**
 * Representa las etapas por las que pasa un pedido óptico.
 */
public enum EstadoPedido {

    REGISTRADO("Registrado"),
    EN_PREPARACION("En preparación"),
    EN_LABORATORIO("En laboratorio"),
    LISTO_PARA_ENTREGA("Listo para entrega"),
    ENTREGADO("Entregado"),
    CANCELADO("Cancelado");

    private final String descripcion;

    EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Indica si el pedido ya no puede continuar cambiando de estado.
     */
    public boolean esEstadoFinal() {
        return this == ENTREGADO || this == CANCELADO;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}


