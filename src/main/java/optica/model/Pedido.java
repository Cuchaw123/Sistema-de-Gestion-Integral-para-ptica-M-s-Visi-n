package main.java.optica.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {

    private String id;
    private String pacienteId;
    private LocalDate fechaRegistro;
    private LocalDate fechaEntregaEstimada;
    private EstadoPedido estado;

    private final List<DetallePedido> detalles;
    private final List<ObservadorPedido> observadores;

    public Pedido(
            String id,
            String pacienteId,
            LocalDate fechaRegistro,
            LocalDate fechaEntregaEstimada
    ) {
        setId(id);
        setPacienteId(pacienteId);
        setFechaRegistro(fechaRegistro);
        setFechaEntregaEstimada(fechaEntregaEstimada);

        this.estado = EstadoPedido.REGISTRADO;
        this.detalles = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        validarTextoObligatorio(id, "identificador del pedido");
        this.id = id.trim();
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        validarTextoObligatorio(
                pacienteId,
                "identificador del paciente"
        );

        this.pacienteId = pacienteId.trim();
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        if (fechaRegistro == null) {
            throw new IllegalArgumentException(
                    "La fecha de registro es obligatoria."
            );
        }

        if (fechaRegistro.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "La fecha de registro no puede ser futura."
            );
        }

        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaEntregaEstimada() {
        return fechaEntregaEstimada;
    }

    public void setFechaEntregaEstimada(LocalDate fechaEntregaEstimada) {
        if (fechaEntregaEstimada == null) {
            throw new IllegalArgumentException(
                    "La fecha estimada de entrega es obligatoria."
            );
        }

        if (fechaRegistro != null
                && fechaEntregaEstimada.isBefore(fechaRegistro)) {

            throw new IllegalArgumentException(
                    "La fecha de entrega no puede ser anterior "
                            + "a la fecha de registro."
            );
        }

        this.fechaEntregaEstimada = fechaEntregaEstimada;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void agregarDetalle(DetallePedido detalle) {
        if (detalle == null) {
            throw new IllegalArgumentException(
                    "El detalle del pedido no puede ser nulo."
            );
        }

        if (estado != EstadoPedido.REGISTRADO) {
            throw new IllegalStateException(
                    "Solo se pueden agregar artículos "
                            + "cuando el pedido está registrado."
            );
        }

        detalles.add(detalle);
    }

    public void eliminarDetalle(String detalleId) {
        validarTextoObligatorio(
                detalleId,
                "identificador del detalle"
        );

        if (estado != EstadoPedido.REGISTRADO) {
            throw new IllegalStateException(
                    "Solo se pueden eliminar artículos "
                            + "cuando el pedido está registrado."
            );
        }

        boolean eliminado = detalles.removeIf(
                detalle -> detalle.getId().equals(detalleId)
        );

        if (!eliminado) {
            throw new IllegalArgumentException(
                    "No se encontró el detalle: " + detalleId
            );
        }
    }

    public List<DetallePedido> getDetalles() {
        return Collections.unmodifiableList(
                new ArrayList<>(detalles)
        );
    }

    public int obtenerCantidadDetalles() {
        return detalles.size();
    }

    public boolean tieneDetalles() {
        return !detalles.isEmpty();
    }

    public double calcularTotal() {
        return detalles.stream()
                .mapToDouble(DetallePedido::calcularSubtotal)
                .sum();
    }


    public void agregarObservador(ObservadorPedido observador) {
        if (observador == null) {
            throw new IllegalArgumentException(
                    "El observador no puede ser nulo."
            );
        }

        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void eliminarObservador(ObservadorPedido observador) {
        if (observador == null) {
            throw new IllegalArgumentException(
                    "El observador no puede ser nulo."
            );
        }

        observadores.remove(observador);
    }

    public int obtenerCantidadObservadores() {
        return observadores.size();
    }

    public void cambiarEstado(
            EstadoPedido nuevoEstado,
            String mensaje
    ) {
        if (nuevoEstado == null) {
            throw new IllegalArgumentException(
                    "El nuevo estado es obligatorio."
            );
        }

        if (mensaje == null || mensaje.isBlank()) {
            throw new IllegalArgumentException(
                    "El mensaje de actualización es obligatorio."
            );
        }

        if (estado == nuevoEstado) {
            throw new IllegalStateException(
                    "El pedido ya se encuentra en el estado "
                            + nuevoEstado + "."
            );
        }

        if (estado.esEstadoFinal()) {
            throw new IllegalStateException(
                    "No se puede cambiar un pedido que está "
                            + "entregado o cancelado."
            );
        }

        if (!esTransicionValida(estado, nuevoEstado)) {
            throw new IllegalStateException(
                    "No se puede cambiar el pedido de "
                            + estado + " a " + nuevoEstado + "."
            );
        }

        if (nuevoEstado == EstadoPedido.EN_PREPARACION
                && detalles.isEmpty()) {

            throw new IllegalStateException(
                    "El pedido debe tener al menos un artículo "
                            + "antes de iniciar su preparación."
            );
        }

        EstadoPedido estadoAnterior = estado;
        estado = nuevoEstado;

        notificarObservadores(
                estadoAnterior,
                nuevoEstado,
                mensaje.trim()
        );
    }

    private boolean esTransicionValida(
            EstadoPedido estadoActual,
            EstadoPedido nuevoEstado
    ) {
        if (nuevoEstado == EstadoPedido.CANCELADO) {
            return true;
        }

        return switch (estadoActual) {
            case REGISTRADO ->
                    nuevoEstado == EstadoPedido.EN_PREPARACION;

            case EN_PREPARACION ->
                    nuevoEstado == EstadoPedido.EN_LABORATORIO;

            case EN_LABORATORIO ->
                    nuevoEstado == EstadoPedido.LISTO_PARA_ENTREGA;

            case LISTO_PARA_ENTREGA ->
                    nuevoEstado == EstadoPedido.ENTREGADO;

            case ENTREGADO, CANCELADO -> false;
        };
    }

    private void notificarObservadores(
            EstadoPedido estadoAnterior,
            EstadoPedido estadoNuevo,
            String mensaje
    ) {
        for (ObservadorPedido observador : observadores) {
            observador.actualizar(
                    id,
                    estadoAnterior,
                    estadoNuevo,
                    mensaje
            );
        }
    }

    private void validarTextoObligatorio(
            String valor,
            String campo
    ) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " es obligatorio."
            );
        }
    }

    @Override
    public String toString() {
        return "Pedido [" + id + "]"
                + " | Paciente: " + pacienteId
                + " | Estado: " + estado
                + " | Registro: " + fechaRegistro
                + " | Entrega estimada: " + fechaEntregaEstimada
                + " | Artículos: " + detalles.size()
                + " | Total: S/ "
                + String.format("%.2f", calcularTotal());
    }
}
