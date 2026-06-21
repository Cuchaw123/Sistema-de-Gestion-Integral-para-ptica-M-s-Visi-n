package main.java.optica.controller;

import main.java.optica.model.CitaOptometrica;
import main.java.optica.model.CitaOptometricaBuilder;
import main.java.optica.model.CitaOptometricaDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CitaOptometricaController {

    private final List<CitaOptometrica> citas;

    public CitaOptometricaController() {
        this.citas = new ArrayList<>();
    }

    public void registrar(CitaOptometrica cita) {
        if (cita == null) {
            throw new IllegalArgumentException(
                    "La cita optométrica no puede ser nula."
            );
        }

        if (buscarPorId(cita.getId()).isPresent()) {
            throw new IllegalStateException(
                    "Ya existe una cita con el identificador "
                            + cita.getId() + "."
            );
        }

        if (existeCruceHorario(
                cita.getOptometristaId(),
                cita.getFechaHora(),
                null
        )) {
            throw new IllegalStateException(
                    "El optometrista ya tiene una cita "
                            + "registrada en ese horario."
            );
        }

        citas.add(cita);
    }

    public CitaOptometrica registrarDesdeDTO(
            CitaOptometricaDTO dto
    ) {
        if (dto == null) {
            throw new IllegalArgumentException(
                    "Los datos de la cita no pueden ser nulos."
            );
        }

        CitaOptometrica cita =
                new CitaOptometricaBuilder()
                        .setId(dto.getId())
                        .setPacienteId(dto.getPacienteId())
                        .setOptometristaId(
                                dto.getOptometristaId()
                        )
                        .setFechaHora(dto.getFechaHora())
                        .setMotivo(dto.getMotivo())
                        .setEstado(dto.getEstado())
                        .build();

        registrar(cita);

        return cita;
    }

    public List<CitaOptometrica> listarTodas() {
        return Collections.unmodifiableList(
                new ArrayList<>(citas)
        );
    }

    public Optional<CitaOptometrica> buscarPorId(String id) {
        validarTexto(id, "identificador");

        return citas.stream()
                .filter(cita ->
                        cita.getId().equalsIgnoreCase(id.trim())
                )
                .findFirst();
    }

    public List<CitaOptometrica> buscarPorPaciente(
            String pacienteId
    ) {
        validarTexto(
                pacienteId,
                "identificador del paciente"
        );

        return citas.stream()
                .filter(cita ->
                        cita.getPacienteId()
                                .equalsIgnoreCase(
                                        pacienteId.trim()
                                )
                )
                .collect(Collectors.toList());
    }

    public List<CitaOptometrica> buscarPorOptometrista(
            String optometristaId
    ) {
        validarTexto(
                optometristaId,
                "identificador del optometrista"
        );

        return citas.stream()
                .filter(cita ->
                        cita.getOptometristaId()
                                .equalsIgnoreCase(
                                        optometristaId.trim()
                                )
                )
                .collect(Collectors.toList());
    }

    public List<CitaOptometrica> buscarPorEstado(
            String estado
    ) {
        validarTexto(estado, "estado");

        return citas.stream()
                .filter(cita ->
                        cita.getEstado()
                                .equalsIgnoreCase(estado.trim())
                )
                .collect(Collectors.toList());
    }

    public void confirmarCita(String citaId) {
        obtenerCitaObligatoria(citaId).confirmar();
    }

    public void marcarCitaAtendida(String citaId) {
        obtenerCitaObligatoria(citaId).marcarAtendida();
    }

    public void cancelarCita(String citaId) {
        obtenerCitaObligatoria(citaId).cancelar();
    }

    public void reprogramarCita(
            String citaId,
            LocalDateTime nuevaFechaHora
    ) {
        CitaOptometrica cita =
                obtenerCitaObligatoria(citaId);

        if (existeCruceHorario(
                cita.getOptometristaId(),
                nuevaFechaHora,
                cita.getId()
        )) {
            throw new IllegalStateException(
                    "El optometrista ya tiene una cita "
                            + "registrada en ese horario."
            );
        }

        cita.reprogramar(nuevaFechaHora);
    }

    public void eliminar(String citaId) {
        CitaOptometrica cita =
                obtenerCitaObligatoria(citaId);

        citas.remove(cita);
    }

    public CitaOptometricaDTO convertirADTO(
            CitaOptometrica cita
    ) {
        if (cita == null) {
            throw new IllegalArgumentException(
                    "La cita no puede ser nula."
            );
        }

        return new CitaOptometricaDTO(
                cita.getId(),
                cita.getPacienteId(),
                cita.getOptometristaId(),
                cita.getFechaHora(),
                cita.getMotivo(),
                cita.getEstado()
        );
    }

    public int obtenerCantidadCitas() {
        return citas.size();
    }

    private boolean existeCruceHorario(
            String optometristaId,
            LocalDateTime fechaHora,
            String citaIdExcluida
    ) {
        return citas.stream()
                .filter(cita ->
                        citaIdExcluida == null
                                || !cita.getId()
                                .equalsIgnoreCase(citaIdExcluida)
                )
                .filter(cita ->
                        !cita.estaFinalizada()
                )
                .anyMatch(cita ->
                        cita.getOptometristaId()
                                .equalsIgnoreCase(optometristaId)
                                && cita.getFechaHora()
                                .equals(fechaHora)
                );
    }

    private CitaOptometrica obtenerCitaObligatoria(
            String citaId
    ) {
        return buscarPorId(citaId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No se encontró la cita: "
                                        + citaId
                        )
                );
    }

    private void validarTexto(
            String valor,
            String campo
    ) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " es obligatorio."
            );
        }
    }
}
