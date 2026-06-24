package main.java.optica.controller;

import main.java.optica.model.HistorialOptico;
import main.java.optica.model.HistorialOpticoDTO;
import main.java.optica.model.HistorialOpticoFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistorialOpticoController {

    private final List<HistorialOptico> historiales;

    public HistorialOpticoController() {
        this.historiales = new ArrayList<>();
    }

    public HistorialOptico registrarHistorial(HistorialOptico historial) {
        if (historial == null) {
            throw new IllegalArgumentException(
                    "El historial óptico no puede ser nulo."
            );
        }

        if (buscarPorId(historial.getId()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe un historial con el ID: "
                            + historial.getId()
            );
        }

        historiales.add(historial);
        return historial;
    }

    public HistorialOptico crearConPlantilla(
            String plantilla,
            String pacienteId,
            String optometristaId
    ) {
        HistorialOptico historial =
                HistorialOpticoFactory.crearHistorialOptico(
                        plantilla,
                        pacienteId,
                        optometristaId
                );

        return registrarHistorial(historial);
    }

    public HistorialOptico registrarDesdeDTO(
            HistorialOpticoDTO dto
    ) {
        if (dto == null) {
            throw new IllegalArgumentException(
                    "El DTO del historial no puede ser nulo."
            );
        }

        HistorialOptico historial = new HistorialOptico(
                dto.getId(),
                dto.getPacienteId(),
                dto.getOptometristaId(),
                dto.getFechaExamen(),
                dto.getDiagnostico(),
                dto.getObservaciones(),
                dto.getOdEsfera(),
                dto.getOdCilindro(),
                dto.getOdEje(),
                dto.getOdAdicion(),
                dto.getOiEsfera(),
                dto.getOiCilindro(),
                dto.getOiEje(),
                dto.getOiAdicion()
        );

        return registrarHistorial(historial);
    }

    public HistorialOptico buscarPorId(String id) {
        if (id == null) {
            return null;
        }

        return historiales.stream()
                .filter(historial ->
                        historial.getId().equalsIgnoreCase(id)
                )
                .findFirst()
                .orElse(null);
    }

    public List<HistorialOptico> buscarPorPaciente(
            String pacienteId
    ) {
        return historiales.stream()
                .filter(historial ->
                        historial.getPacienteId()
                                .equalsIgnoreCase(pacienteId)
                )
                .collect(Collectors.toList());
    }

    public List<HistorialOptico> buscarPorOptometrista(
            String optometristaId
    ) {
        return historiales.stream()
                .filter(historial ->
                        historial.getOptometristaId()
                                .equalsIgnoreCase(optometristaId)
                )
                .collect(Collectors.toList());
    }

    public List<HistorialOptico> listarHistoriales() {
        return new ArrayList<>(historiales);
    }

    public boolean actualizarHistorial(
            HistorialOptico historialActualizado
    ) {
        if (historialActualizado == null) {
            return false;
        }

        for (int i = 0; i < historiales.size(); i++) {
            HistorialOptico historial = historiales.get(i);

            if (historial.getId().equalsIgnoreCase(
                    historialActualizado.getId()
            )) {
                historiales.set(i, historialActualizado);
                return true;
            }
        }

        return false;
    }

    public boolean eliminarHistorial(String id) {
        if (id == null) {
            return false;
        }

        return historiales.removeIf(historial ->
                historial.getId().equalsIgnoreCase(id)
        );
    }

    public HistorialOpticoDTO convertirADTO(
            HistorialOptico historial
    ) {
        if (historial == null) {
            return null;
        }

        return new HistorialOpticoDTO(
                historial.getId(),
                historial.getPacienteId(),
                historial.getOptometristaId(),
                historial.getFechaExamen(),
                historial.getDiagnostico(),
                historial.getObservaciones(),
                historial.getOdEsfera(),
                historial.getOdCilindro(),
                historial.getOdEje(),
                historial.getOdAdicion(),
                historial.getOiEsfera(),
                historial.getOiCilindro(),
                historial.getOiEje(),
                historial.getOiAdicion()
        );
    }

    public List<HistorialOpticoDTO> listarHistorialesDTO() {
        return historiales.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public int contarHistoriales() {
        return historiales.size();
    }
}
