package main.java.optica.soporte;

/** Observador concreto: actualiza el panel del optómetra responsable. */
public class NotificadorOptometra implements PedidoObserver {
    private final String nombreOptometra;

    public NotificadorOptometra(String nombreOptometra) {
        this.nombreOptometra = nombreOptometra;
    }

    @Override
    public void actualizar(String idPedido, String nuevoEstado) {
        System.out.println("   [Panel " + nombreOptometra + "] Pedido " + idPedido
                + " actualizado a: " + nuevoEstado);
    }
}