package main.java.optica.soporte;

import main.java.optica.model.Optometrista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptometristaRepositoryMySQL
        implements OptometristaRepository {

    private final String url;
    private final String usuario;
    private final String clave;

    public OptometristaRepositoryMySQL() {
        this(
                "jdbc:mysql://localhost:3306/optica_mas_vision",
                "root",
                ""
        );
    }

    public OptometristaRepositoryMySQL(
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
    public void guardar(Optometrista optometrista) {
        validarOptometrista(optometrista);

        String sql =
                "INSERT INTO optometristas " +
                        "(id, nombre, apellido, area_atencion, " +
                        "registro_profesional, disponible) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conexion = obtenerConexion();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            colocarParametros(sentencia, optometrista);
            sentencia.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No se pudo guardar el optometrista.",
                    e
            );
        }
    }

    @Override
    public Optional<Optometrista> buscarPorId(String id) {
        if (id == null || id.isBlank()) {
            return Optional.empty();
        }

        String sql =
                "SELECT id, nombre, apellido, area_atencion, " +
                        "registro_profesional, disponible " +
                        "FROM optometristas WHERE id = ?";

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
                    "No se pudo buscar el optometrista.",
                    e
            );
        }
    }

    @Override
    public List<Optometrista> listarTodos() {
        List<Optometrista> optometristas =
                new ArrayList<>();

        String sql =
                "SELECT id, nombre, apellido, area_atencion, " +
                        "registro_profesional, disponible " +
                        "FROM optometristas ORDER BY apellido, nombre";

        try (
                Connection conexion = obtenerConexion();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql);
                ResultSet resultado = sentencia.executeQuery()
        ) {
            while (resultado.next()) {
                optometristas.add(
                        convertirResultado(resultado)
                );
            }

            return optometristas;

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No se pudieron listar los optometristas.",
                    e
            );
        }
    }

    @Override
    public boolean actualizar(
            Optometrista optometrista
    ) {
        validarOptometrista(optometrista);

        String sql =
                "UPDATE optometristas SET " +
                        "nombre = ?, apellido = ?, " +
                        "area_atencion = ?, " +
                        "registro_profesional = ?, " +
                        "disponible = ? WHERE id = ?";

        try (
                Connection conexion = obtenerConexion();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            sentencia.setString(
                    1,
                    optometrista.getNombre()
            );

            sentencia.setString(
                    2,
                    optometrista.getApellido()
            );

            sentencia.setString(
                    3,
                    optometrista.getAreaAtencion()
            );

            sentencia.setString(
                    4,
                    optometrista.getNumeroRegistroProfesional()
            );

            sentencia.setBoolean(
                    5,
                    optometrista.isDisponible()
            );

            sentencia.setString(
                    6,
                    optometrista.getId()
            );

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No se pudo actualizar el optometrista.",
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
                "DELETE FROM optometristas WHERE id = ?";

        try (
                Connection conexion = obtenerConexion();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            sentencia.setString(1, id.trim());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new IllegalStateException(
                    "No se pudo eliminar el optometrista.",
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
                "SELECT 1 FROM optometristas WHERE id = ?";

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
                    "No se pudo verificar el optometrista.",
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
            Class.forName(
                    "com.mysql.cj.jdbc.Driver"
            );

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
                "CREATE TABLE IF NOT EXISTS optometristas (" +
                        "id VARCHAR(50) PRIMARY KEY, " +
                        "nombre VARCHAR(100) NOT NULL, " +
                        "apellido VARCHAR(100) NOT NULL, " +
                        "area_atencion VARCHAR(120) NOT NULL, " +
                        "registro_profesional VARCHAR(80) NOT NULL, " +
                        "disponible BOOLEAN NOT NULL" +
                        ")";

        try (Statement sentencia = conexion.createStatement()) {
            sentencia.executeUpdate(sql);
        }
    }

    private void colocarParametros(
            PreparedStatement sentencia,
            Optometrista optometrista
    ) throws SQLException {

        sentencia.setString(
                1,
                optometrista.getId()
        );

        sentencia.setString(
                2,
                optometrista.getNombre()
        );

        sentencia.setString(
                3,
                optometrista.getApellido()
        );

        sentencia.setString(
                4,
                optometrista.getAreaAtencion()
        );

        sentencia.setString(
                5,
                optometrista.getNumeroRegistroProfesional()
        );

        sentencia.setBoolean(
                6,
                optometrista.isDisponible()
        );
    }

    private Optometrista convertirResultado(
            ResultSet resultado
    ) throws SQLException {

        return new Optometrista(
                resultado.getString("id"),
                resultado.getString("nombre"),
                resultado.getString("apellido"),
                resultado.getString("area_atencion"),
                resultado.getString(
                        "registro_profesional"
                ),
                resultado.getBoolean("disponible")
        );
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
