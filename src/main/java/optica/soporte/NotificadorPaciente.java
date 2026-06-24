package main.java.optica.soporte;

/** Observador concreto: notifica al paciente por SMS sobre su pedido. */
public class NotificadorPaciente implements PedidoObserver {
    private final String nombrePaciente;

    public NotificadorPaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    @Override
    public void actualizar(String idPedido, String nuevoEstado) {
        System.out.println("   [SMS a " + nombrePaciente + "] Su pedido " + idPedido
                + " ahora esta: " + nuevoEstado);
    }
}