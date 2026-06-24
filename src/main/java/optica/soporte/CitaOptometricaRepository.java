package main.java.optica.soporte;

import main.java.optica.model.CitaOptometrica;

import java.util.List;
import java.util.Optional;

public interface CitaOptometricaRepository {

    void guardar(CitaOptometrica cita);

    Optional<CitaOptometrica> buscarPorId(String id);

    List<CitaOptometrica> listarTodas();

    List<CitaOptometrica> buscarPorPaciente(String pacienteId);

    List<CitaOptometrica> buscarPorOptometrista(
            String optometristaId
    );

    boolean actualizar(CitaOptometrica cita);

    boolean eliminarPorId(String id);

    boolean existePorId(String id);
}