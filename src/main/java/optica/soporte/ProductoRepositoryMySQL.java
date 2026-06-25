package main.java.optica.soporte;

import main.java.optica.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoRepositoryMySQL {

    private final String url;
    private final String usuario;
    private final String clave;

    public ProductoRepositoryMySQL(
            String url,
            String usuario,
            String clave
    ) {
        this.url = url;
        this.usuario = usuario;
        this.clave = clave;
    }

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(
                url,
                usuario,
                clave
        );
    }

    public void guardar(Producto producto) {
        String sql =
                "INSERT INTO productos " +
                        "(id, nombre, categoria, descripcion, precio, stock) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conexion = conectar();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            sentencia.setString(1, producto.getId());
            sentencia.setString(2, producto.getNombre());
            sentencia.setString(3, producto.getCategoria());
            sentencia.setString(4, producto.getDescripcion());
            sentencia.setDouble(5, producto.getPrecio());
            sentencia.setInt(6, producto.getStock());

            sentencia.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "No se pudo guardar el producto: "
                            + e.getMessage()
            );
        }
    }

    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();

        String sql =
                "SELECT * FROM productos ORDER BY nombre";

        try (
                Connection conexion = conectar();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql);
                ResultSet resultado =
                        sentencia.executeQuery()
        ) {
            while (resultado.next()) {
                productos.add(convertirProducto(resultado));
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "No se pudieron listar los productos: "
                            + e.getMessage()
            );
        }

        return productos;
    }

    public Optional<Producto> buscarPorId(String id) {
        String sql =
                "SELECT * FROM productos WHERE id = ?";

        try (
                Connection conexion = conectar();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            sentencia.setString(1, id);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return Optional.of(
                            convertirProducto(resultado)
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "No se pudo buscar el producto: "
                            + e.getMessage()
            );
        }

        return Optional.empty();
    }

    public void aumentarStock(
            String id,
            int cantidad
    ) {
        Producto producto = buscarProducto(id);

        producto.aumentarStock(cantidad);

        actualizarStock(
                id,
                producto.getStock()
        );
    }

    public void disminuirStock(
            String id,
            int cantidad
    ) {
        Producto producto = buscarProducto(id);

        producto.disminuirStock(cantidad);

        actualizarStock(
                id,
                producto.getStock()
        );
    }

    public List<Producto> listarStockBajo(
            int limite
    ) {
        List<Producto> productos = new ArrayList<>();

        String sql =
                "SELECT * FROM productos " +
                        "WHERE stock <= ? ORDER BY stock";

        try (
                Connection conexion = conectar();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            sentencia.setInt(1, limite);

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    productos.add(
                            convertirProducto(resultado)
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "No se pudo consultar el stock: "
                            + e.getMessage()
            );
        }

        return productos;
    }

    private Producto buscarProducto(String id) {
        return buscarPorId(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No existe un producto con ID: " + id
                        )
                );
    }

    private void actualizarStock(
            String id,
            int nuevoStock
    ) {
        String sql =
                "UPDATE productos SET stock = ? WHERE id = ?";

        try (
                Connection conexion = conectar();
                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {
            sentencia.setInt(1, nuevoStock);
            sentencia.setString(2, id);
            sentencia.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "No se pudo actualizar el stock: "
                            + e.getMessage()
            );
        }
    }

    private Producto convertirProducto(
            ResultSet resultado
    ) throws SQLException {

        return new Producto(
                resultado.getString("id"),
                resultado.getString("nombre"),
                resultado.getString("categoria"),
                resultado.getString("descripcion"),
                resultado.getDouble("precio"),
                resultado.getInt("stock")
        );
    }
}
