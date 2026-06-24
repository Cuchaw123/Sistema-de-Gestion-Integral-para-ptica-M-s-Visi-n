package main.java.optica.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotificacionPedido implements ObservadorPedido {

    private String destinatario;
    private String canal;
    private final List<String> historial;

    public NotificacionPedido(String destinatario, String canal) {
        setDestinatario(destinatario);
        setCanal(canal);
        this.historial = new ArrayList<>();
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        if (destinatario == null || destinatario.isBlank()) {
            throw new IllegalArgumentException(
                    "El destinatario de la notificación es obligatorio."
            );
        }

        this.destinatario = destinatario.trim();
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        if (canal == null || canal.isBlank()) {
            throw new IllegalArgumentException(
                    "El canal de notificación es obligatorio."
            );
        }

        this.canal = canal.trim();
    }

    @Override
    public void actualizar(
            String pedidoId,
            EstadoPedido estadoAnterior,
            EstadoPedido estadoNuevo,
            String mensaje
    ) {
        String notificacion = LocalDateTime.now()
                + " | Pedido: " + pedidoId
                + " | Destinatario: " + destinatario
                + " | Canal: " + canal
                + " | Estado anterior: " + estadoAnterior
                + " | Estado nuevo: " + estadoNuevo
                + " | Mensaje: " + mensaje;

        historial.add(notificacion);

        System.out.println("Notificación enviada: " + notificacion);
    }

    public List<String> getHistorial() {
        return Collections.unmodifiableList(
                new ArrayList<>(historial)
        );
    }

    public int obtenerCantidadNotificaciones() {
        return historial.size();
    }

    public boolean tieneNotificaciones() {
        return !historial.isEmpty();
    }

    public void limpiarHistorial() {
        historial.clear();
    }

    @Override
    public String toString() {
        return "NotificacionPedido"
                + " | Destinatario: " + destinatario
                + " | Canal: " + canal
                + " | Notificaciones: " + historial.size();
    }
}

