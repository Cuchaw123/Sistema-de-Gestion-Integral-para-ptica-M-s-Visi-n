package main.java.optica.soporte;

import main.java.optica.model.CitaOptometrica;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CitaOptometricaRepositoryArchivo
        implements CitaOptometricaRepository {

    private static final String SEPARADOR = ";";

    private final Path rutaArchivo;

    public CitaOptometricaRepositoryArchivo() {
        this(Path.of("data", "citas_optometricas.txt"));
    }

    public CitaOptometricaRepositoryArchivo(Path rutaArchivo) {
        if (rutaArchivo == null) {
            throw new IllegalArgumentException(
                    "La ruta del archivo es obligatoria."
            );
        }

        this.rutaArchivo = rutaArchivo;
        prepararArchivo();
    }

    @Override
    public synchronized void guardar(CitaOptometrica cita) {
        validarCita(cita);

        if (existePorId(cita.getId())) {
            throw new IllegalArgumentException(
                    "Ya existe una cita con el ID: " + cita.getId()
            );
        }

        List<CitaOptometrica> citas = leerTodas();
        citas.add(cita);
        guardarTodas(citas);
    }

    @Override
    public synchronized Optional<CitaOptometrica> buscarPorId(
            String id
    ) {
        if (id == null || id.isBlank()) {
            return Optional.empty();
        }

        return leerTodas()
                .stream()
                .filter(cita ->
                        cita.getId().equalsIgnoreCase(id.trim())
                )
                .findFirst();
    }

    @Override
    public synchronized List<CitaOptometrica> listarTodas() {
        return new ArrayList<>(leerTodas());
    }

    @Override
    public synchronized List<CitaOptometrica> buscarPorPaciente(
            String pacienteId
    ) {
        if (pacienteId == null || pacienteId.isBlank()) {
            return new ArrayList<>();
        }

        return leerTodas()
                .stream()
                .filter(cita ->
                        cita.getPacienteId()
                                .equalsIgnoreCase(pacienteId.trim())
                )
                .collect(Collectors.toList());
    }

    @Override
    public synchronized List<CitaOptometrica> buscarPorOptometrista(
            String optometristaId
    ) {
        if (optometristaId == null || optometristaId.isBlank()) {
            return new ArrayList<>();
        }

        return leerTodas()
                .stream()
                .filter(cita ->
                        cita.getOptometristaId()
                                .equalsIgnoreCase(
                                        optometristaId.trim()
                                )
                )
                .collect(Collectors.toList());
    }

    @Override
    public synchronized boolean actualizar(
            CitaOptometrica cita
    ) {
        validarCita(cita);

        List<CitaOptometrica> citas = leerTodas();

        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).getId()
                    .equalsIgnoreCase(cita.getId())) {

                citas.set(i, cita);
                guardarTodas(citas);
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

        List<CitaOptometrica> citas = leerTodas();

        boolean eliminada = citas.removeIf(cita ->
                cita.getId().equalsIgnoreCase(id.trim())
        );

        if (eliminada) {
            guardarTodas(citas);
        }

        return eliminada;
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
                    "No se pudo preparar el archivo de citas.",
                    e
            );
        }
    }

    private List<CitaOptometrica> leerTodas() {
        List<CitaOptometrica> citas = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(
                    rutaArchivo,
                    StandardCharsets.UTF_8
            );

            for (String linea : lineas) {
                if (linea == null || linea.isBlank()) {
                    continue;
                }

                citas.add(convertirLineaACita(linea));
            }

            return citas;

        } catch (IOException e) {
            throw new IllegalStateException(
                    "No se pudo leer el archivo de citas.",
                    e
            );
        }
    }

    private void guardarTodas(
            List<CitaOptometrica> citas
    ) {
        List<String> lineas = citas.stream()
                .map(this::convertirCitaALinea)
                .collect(Collectors.toList());

        try {
            Files.write(
                    rutaArchivo,
                    lineas,
                    StandardCharsets.UTF_8
            );

        } catch (IOException e) {
            throw new IllegalStateException(
                    "No se pudo guardar el archivo de citas.",
                    e
            );
        }
    }

    private String convertirCitaALinea(
            CitaOptometrica cita
    ) {
        return limpiarCampo(cita.getId())
                + SEPARADOR
                + limpiarCampo(cita.getPacienteId())
                + SEPARADOR
                + limpiarCampo(cita.getOptometristaId())
                + SEPARADOR
                + cita.getFechaHora()
                + SEPARADOR
                + limpiarCampo(cita.getMotivo())
                + SEPARADOR
                + limpiarCampo(cita.getEstado());
    }

    private CitaOptometrica convertirLineaACita(
            String linea
    ) {
        String[] datos = linea.split(SEPARADOR, -1);

        if (datos.length != 6) {
            throw new IllegalStateException(
                    "Registro de cita inválido: " + linea
            );
        }

        return new CitaOptometrica(
                datos[0],
                datos[1],
                datos[2],
                LocalDateTime.parse(datos[3]),
                datos[4],
                datos[5]
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

    private void validarCita(CitaOptometrica cita) {
        if (cita == null) {
            throw new IllegalArgumentException(
                    "La cita optométrica no puede ser nula."
            );
        }
    }
}
