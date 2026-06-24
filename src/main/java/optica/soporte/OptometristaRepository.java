package main.java.optica.soporte;

import main.java.optica.model.Optometrista;

import java.util.List;
import java.util.Optional;

public interface OptometristaRepository {

    void guardar(Optometrista optometrista);

    Optional<Optometrista> buscarPorId(String id);

    List<Optometrista> listarTodos();

    boolean actualizar(Optometrista optometrista);

    boolean eliminarPorId(String id);

    boolean existePorId(String id);
}
