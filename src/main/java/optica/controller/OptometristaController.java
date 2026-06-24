package main.java.optica.controller;

import main.java.optica.model.Optometrista;
import main.java.optica.model.OptometristaBuilder;
import main.java.optica.model.OptometristaDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptometristaController {

    private final List<Optometrista> optometristas;

    public OptometristaController() {
        this.optometristas = new ArrayList<>();
    }

    public void registrar(Optometrista optometrista) {
        if (optometrista == null) {
            throw new IllegalArgumentException(
                    "El optometrista no puede ser nulo."
            );
        }

        if (buscarPorId(optometrista.getId()).isPresent()) {
            throw new IllegalStateException(
                    "Ya existe un optometrista con el identificador "
                            + optometrista.getId() + "."
            );
        }

        optometristas.add(optometrista);
    }

    public Optometrista registrarDesdeDTO(OptometristaDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException(
                    "Los datos del optometrista no pueden ser nulos."
            );
        }

        Optometrista optometrista = new OptometristaBuilder()
                .setId(dto.getId())
                .setNombre(dto.getNombre())
                .setApellido(dto.getApellido())
                .setAreaAtencion(dto.getAreaAtencion())
                .setNumeroRegistroProfesional(
                        dto.getNumeroRegistroProfesional()
                )
                .setDisponible(dto.isDisponible())
                .build();

        registrar(optometrista);

        return optometrista;
    }

    public List<Optometrista> listarTodos() {
        return Collections.unmodifiableList(
                new ArrayList<>(optometristas)
        );
    }

    public Optional<Optometrista> buscarPorId(String id) {
        validarTexto(id, "identificador");

        return optometristas.stream()
                .filter(optometrista ->
                        optometrista.getId().equalsIgnoreCase(id.trim())
                )
                .findFirst();
    }

    public List<Optometrista> buscarPorNombre(String texto) {
        validarTexto(texto, "nombre");

        String textoBuscado = texto.trim().toLowerCase();

        return optometristas.stream()
                .filter(optometrista ->
                        optometrista.obtenerNombreCompleto()
                                .toLowerCase()
                                .contains(textoBuscado)
                )
                .collect(Collectors.toList());
    }

    public List<Optometrista> listarDisponibles() {
        return optometristas.stream()
                .filter(Optometrista::isDisponible)
                .collect(Collectors.toList());
    }

    public void actualizarDisponibilidad(
            String id,
            boolean disponible
    ) {
        Optometrista optometrista = buscarPorId(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No se encontró el optometrista: " + id
                        )
                );

        optometrista.setDisponible(disponible);
    }

    public void eliminar(String id) {
        Optometrista optometrista = buscarPorId(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No se encontró el optometrista: " + id
                        )
                );

        optometristas.remove(optometrista);
    }

    public OptometristaDTO convertirADTO(
            Optometrista optometrista
    ) {
        if (optometrista == null) {
            throw new IllegalArgumentException(
                    "El optometrista no puede ser nulo."
            );
        }

        return new OptometristaDTO(
                optometrista.getId(),
                optometrista.getNombre(),
                optometrista.getApellido(),
                optometrista.getAreaAtencion(),
                optometrista.getNumeroRegistroProfesional(),
                optometrista.isDisponible()
        );
    }

    public int obtenerCantidadOptometristas() {
        return optometristas.size();
    }

    private void validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " es obligatorio."
            );
        }
    }
}