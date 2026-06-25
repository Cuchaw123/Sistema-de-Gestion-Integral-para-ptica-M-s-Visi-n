package main.java.optica.soporte;

import main.java.optica.model.CitaOptometrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CitaOptometricaRepositoryMySQL
        implements CitaOptometricaRepository {

    private final String url;
    private final String usuario;
    private final String clave;

    public CitaOptometricaRepositoryMySQL() {
        this(
                "jdbc:mysql://localhost:3306/optica_mas_vision",
                "root",
                ""
        );
    }

    public CitaOptometricaRepositoryMySQL(
            String url,
            String usuario,
            String clave
    ) {
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException(
                    "La URL de la base de datos es obligatoria."
            );
        }

        this.url = url;
        this.usuario = usuario;
        this.clave = clave;
    }

    @Override
    public void guardar(CitaOptometrica cita) {
        validarCita(cita);

        String sql =
                "INSERT INTO citas_optometricas " +
                        "(id, paciente_id, optometrista_id, fecha_hora, motivo, estado) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conexion = obtenerConexion();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            colocarParametros(sentencia, cita);
            sentencia.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No se pudo guardar la cita optométrica.",
                    e
            );
        }
    }

    @Override
    public Optional<CitaOptometrica> buscarPorId(String id) {
        if (id == null || id.isBlank()) {
            return Optional.empty();
        }

        String sql =
                "SELECT id, paciente_id, optometrista_id, " +
                        "fecha_hora, motivo, estado " +
                        "FROM citas_optometricas WHERE id = ?";

        try (
                Connection conexion = obtenerConexion();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            sentencia.setString(1, id.trim());

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return Optional.of(
                            convertirResultado(resultado)
                    );
                }
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No se pudo buscar la cita optométrica.",
                    e
            );
        }
    }

    @Override
    public List<CitaOptometrica> listarTodas() {
        List<CitaOptometrica> citas = new ArrayList<>();

        String sql =
                "SELECT id, paciente_id, optometrista_id, " +
                        "fecha_hora, motivo, estado " +
                        "FROM citas_optometricas ORDER BY fecha_hora";

        try (
                Connection conexion = obtenerConexion();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql);
                ResultSet resultado = sentencia.executeQuery()
        ) {
            while (resultado.next()) {
                citas.add(convertirResultado(resultado));
            }

            return citas;

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No se pudieron listar las citas optométricas.",
                    e
            );
        }
    }

    @Override
    public List<CitaOptometrica> buscarPorPaciente(
            String pacienteId
    ) {
        if (pacienteId == null || pacienteId.isBlank()) {
            return new ArrayList<>();
        }

        String sql =
                "SELECT id, paciente_id, optometrista_id, " +
                        "fecha_hora, motivo, estado " +
                        "FROM citas_optometricas " +
                        "WHERE paciente_id = ? ORDER BY fecha_hora";

        return ejecutarBusqueda(sql, pacienteId.trim());
    }

    @Override
    public List<CitaOptometrica> buscarPorOptometrista(
            String optometristaId
    ) {
        if (optometristaId == null || optometristaId.isBlank()) {
            return new ArrayList<>();
        }

        String sql =
                "SELECT id, paciente_id, optometrista_id, " +
                        "fecha_hora, motivo, estado " +
                        "FROM citas_optometricas " +
                        "WHERE optometrista_id = ? ORDER BY fecha_hora";

        return ejecutarBusqueda(sql, optometristaId.trim());
    }

    @Override
    public boolean actualizar(CitaOptometrica cita) {
        validarCita(cita);

        String sql =
                "UPDATE citas_optometricas SET " +
                        "paciente_id = ?, " +
                        "optometrista_id = ?, " +
                        "fecha_hora = ?, " +
                        "motivo = ?, " +
                        "estado = ? " +
                        "WHERE id = ?";

        try (
                Connection conexion = obtenerConexion();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            sentencia.setString(1, cita.getPacienteId());
            sentencia.setString(2, cita.getOptometristaId());
            sentencia.setObject(3, cita.getFechaHora());
            sentencia.setString(4, cita.getMotivo());
            sentencia.setString(5, cita.getEstado());
            sentencia.setString(6, cita.getId());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No se pudo actualizar la cita optométrica.",
                    e
            );
        }
    }

    @Override
    public boolean eliminarPorId(String id) {
        if (id == null || id.isBlank()) {
            return false;
        }

        String sql =
                "DELETE FROM citas_optometricas WHERE id = ?";

        try (
                Connection conexion = obtenerConexion();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            sentencia.setString(1, id.trim());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No se pudo eliminar la cita optométrica.",
                    e
            );
        }
    }

    @Override
    public boolean existePorId(String id) {
        if (id == null || id.isBlank()) {
            return false;
        }

        String sql =
                "SELECT 1 FROM citas_optometricas WHERE id = ?";

        try (
                Connection conexion = obtenerConexion();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            sentencia.setString(1, id.trim());

            try (ResultSet resultado = sentencia.executeQuery()) {
                return resultado.next();
            }

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No se pudo verificar la cita optométrica.",
                    e
            );
        }
    }

    private List<CitaOptometrica> ejecutarBusqueda(
            String sql,
            String valor
    ) {
        List<CitaOptometrica> citas = new ArrayList<>();

        try (
                Connection conexion = obtenerConexion();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            sentencia.setString(1, valor);

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    citas.add(convertirResultado(resultado));
                }
            }

            return citas;

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No se pudieron buscar las citas optométricas.",
                    e
            );
        }
    }

    private Connection obtenerConexion()
            throws SQLException {

        cargarDriverMySQL();

        Connection conexion = DriverManager.getConnection(
                url,
                usuario,
                clave
        );

        prepararTabla(conexion);

        return conexion;
    }

    private void cargarDriverMySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(
                    "No se encontró el conector JDBC de MySQL.",
                    e
            );
        }
    }

    private void prepararTabla(Connection conexion)
            throws SQLException {

        String sql =
                "CREATE TABLE IF NOT EXISTS citas_optometricas (" +
                        "id VARCHAR(50) PRIMARY KEY, " +
                        "paciente_id VARCHAR(50) NOT NULL, " +
                        "optometrista_id VARCHAR(50) NOT NULL, " +
                        "fecha_hora DATETIME NOT NULL, " +
                        "motivo VARCHAR(255) NOT NULL, " +
                        "estado VARCHAR(50) NOT NULL" +
                        ")";

        try (Statement sentencia = conexion.createStatement()) {
            sentencia.executeUpdate(sql);
        }
    }

    private void colocarParametros(
            PreparedStatement sentencia,
            CitaOptometrica cita
    ) throws SQLException {

        sentencia.setString(1, cita.getId());
        sentencia.setString(2, cita.getPacienteId());
        sentencia.setString(3, cita.getOptometristaId());
        sentencia.setObject(4, cita.getFechaHora());
        sentencia.setString(5, cita.getMotivo());
        sentencia.setString(6, cita.getEstado());
    }

    private CitaOptometrica convertirResultado(
            ResultSet resultado
    ) throws SQLException {

        LocalDateTime fechaHora =
                resultado.getTimestamp("fecha_hora")
                        .toLocalDateTime();

        return new CitaOptometrica(
                resultado.getString("id"),
                resultado.getString("paciente_id"),
                resultado.getString("optometrista_id"),
                fechaHora,
                resultado.getString("motivo"),
                resultado.getString("estado")
        );
    }

    private void validarCita(CitaOptometrica cita) {
        if (cita == null) {
            throw new IllegalArgumentException(
                    "La cita optométrica no puede ser nula."
            );
        }
    }
}