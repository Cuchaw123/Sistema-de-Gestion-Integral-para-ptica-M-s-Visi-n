package main.java.optica.soporte;

import main.java.optica.model.Optometrista;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptometristaRepositoryArchivo
        implements OptometristaRepository {

    private static final String SEPARADOR = ";";

    private final Path rutaArchivo;

    public OptometristaRepositoryArchivo() {
        this(Path.of("data", "optometristas.txt"));
    }

    public OptometristaRepositoryArchivo(Path rutaArchivo) {
        if (rutaArchivo == null) {
            throw new IllegalArgumentException(
                    "La ruta del archivo es obligatoria."
            );
        }

        this.rutaArchivo = rutaArchivo;
        prepararArchivo();
    }

    @Override
    public synchronized void guardar(Optometrista optometrista) {
        validarOptometrista(optometrista);

        if (existePorId(optometrista.getId())) {
            throw new IllegalArgumentException(
                    "Ya existe un optometrista con el ID: "
                            + optometrista.getId()
            );
        }

        List<Optometrista> optometristas = leerTodos();
        optometristas.add(optometrista);
        guardarTodos(optometristas);
    }

    @Override
    public synchronized Optional<Optometrista> buscarPorId(
            String id
    ) {
        if (id == null || id.isBlank()) {
            return Optional.empty();
        }

        return leerTodos()
                .stream()
                .filter(optometrista ->
                        optometrista.getId()
                                .equalsIgnoreCase(id.trim())
                )
                .findFirst();
    }

    @Override
    public synchronized List<Optometrista> listarTodos() {
        return new ArrayList<>(leerTodos());
    }

    @Override
    public synchronized boolean actualizar(
            Optometrista optometrista
    ) {
        validarOptometrista(optometrista);

        List<Optometrista> optometristas = leerTodos();

        for (int i = 0; i < optometristas.size(); i++) {
            Optometrista actual = optometristas.get(i);

            if (actual.getId().equalsIgnoreCase(
                    optometrista.getId()
            )) {
                optometristas.set(i, optometrista);
                guardarTodos(optometristas);
                return true;
            }
        }

        return false;
    }

    @Override
    public synchronized boolean eliminarPorId(String id) {
        if (id == null || id.isBlank()) {
            return false;
        }

        List<Optometrista> optometristas = leerTodos();

        boolean eliminado = optometristas.removeIf(
                optometrista ->
                        optometrista.getId()
                                .equalsIgnoreCase(id.trim())
        );

        if (eliminado) {
            guardarTodos(optometristas);
        }

        return eliminado;
    }

    @Override
    public synchronized boolean existePorId(String id) {
        return buscarPorId(id).isPresent();
    }

    private void prepararArchivo() {
        try {
            Path carpeta = rutaArchivo.getParent();

            if (carpeta != null) {
                Files.createDirectories(carpeta);
            }

            if (Files.notExists(rutaArchivo)) {
                Files.createFile(rutaArchivo);
            }

        } catch (IOException e) {
            throw new IllegalStateException(
                    "No se pudo preparar el archivo de optometristas.",
                    e
            );
        }
    }

    private List<Optometrista> leerTodos() {
        List<Optometrista> optometristas = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(
                    rutaArchivo,
                    StandardCharsets.UTF_8
            );

            for (String linea : lineas) {
                if (linea == null || linea.isBlank()) {
                    continue;
                }

                Optometrista optometrista =
                        convertirLineaAOptometrista(linea);

                optometristas.add(optometrista);
            }

            return optometristas;

        } catch (IOException e) {
            throw new IllegalStateException(
                    "No se pudo leer el archivo de optometristas.",
                    e
            );
        }
    }

    private void guardarTodos(
            List<Optometrista> optometristas
    ) {
        List<String> lineas = optometristas
                .stream()
                .map(this::convertirOptometristaALinea)
                .toList();

        try {
            Files.write(
                    rutaArchivo,
                    lineas,
                    StandardCharsets.UTF_8
            );

        } catch (IOException e) {
            throw new IllegalStateException(
                    "No se pudo guardar el archivo de optometristas.",
                    e
            );
        }
    }

    private String convertirOptometristaALinea(
            Optometrista optometrista
    ) {
        return limpiarCampo(optometrista.getId())
                + SEPARADOR
                + limpiarCampo(optometrista.getNombre())
                + SEPARADOR
                + limpiarCampo(optometrista.getApellido())
                + SEPARADOR
                + limpiarCampo(optometrista.getAreaAtencion())
                + SEPARADOR
                + limpiarCampo(
                optometrista.getNumeroRegistroProfesional()
        )
                + SEPARADOR
                + optometrista.isDisponible();
    }

    private Optometrista convertirLineaAOptometrista(
            String linea
    ) {
        String[] datos = linea.split(SEPARADOR, -1);

        if (datos.length != 6) {
            throw new IllegalStateException(
                    "Registro de optometrista inválido: " + linea
            );
        }

        return new Optometrista(
                datos[0],
                datos[1],
                datos[2],
                datos[3],
                datos[4],
                Boolean.parseBoolean(datos[5])
        );
    }

    private String limpiarCampo(String valor) {
        if (valor == null) {
            return "";
        }

        return valor
                .replace(SEPARADOR, ",")
                .replace("\n", " ")
                .replace("\r", " ")
                .trim();
    }

    private void validarOptometrista(
            Optometrista optometrista
    ) {
        if (optometrista == null) {
            throw new IllegalArgumentException(
                    "El optometrista no puede ser nulo."
            );
        }
    }
}
