package main.java.optica.model;

public class DetallePedido {

    private String id;
    private String articuloId;
    private String tipoArticulo;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public DetallePedido(
            String id,
            String articuloId,
            String tipoArticulo,
            String descripcion,
            int cantidad,
            double precioUnitario
    ) {
        setId(id);
        setArticuloId(articuloId);
        setTipoArticulo(tipoArticulo);
        setDescripcion(descripcion);
        setCantidad(cantidad);
        setPrecioUnitario(precioUnitario);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        validarTextoObligatorio(id, "identificador del detalle");
        this.id = id.trim();
    }

    public String getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(String articuloId) {
        validarTextoObligatorio(
                articuloId,
                "identificador del artículo"
        );

        this.articuloId = articuloId.trim();
    }

    public String getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(String tipoArticulo) {
        validarTextoObligatorio(tipoArticulo, "tipo de artículo");
        this.tipoArticulo = tipoArticulo.trim();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        validarTextoObligatorio(descripcion, "descripción");
        this.descripcion = descripcion.trim();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad debe ser mayor que cero."
            );
        }

        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (Double.isNaN(precioUnitario)
                || Double.isInfinite(precioUnitario)) {

            throw new IllegalArgumentException(
                    "El precio unitario debe ser un número válido."
            );
        }

        if (precioUnitario < 0) {
            throw new IllegalArgumentException(
                    "El precio unitario no puede ser negativo."
            );
        }

        this.precioUnitario = precioUnitario;
    }

    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    public void aumentarCantidad(int cantidadAdicional) {
        if (cantidadAdicional <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad adicional debe ser mayor que cero."
            );
        }

        cantidad += cantidadAdicional;
    }

    public void disminuirCantidad(int cantidadRetirada) {
        if (cantidadRetirada <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad retirada debe ser mayor que cero."
            );
        }

        if (cantidadRetirada >= cantidad) {
            throw new IllegalStateException(
                    "La cantidad retirada debe ser menor que la cantidad actual."
            );
        }

        cantidad -= cantidadRetirada;
    }

    private void validarTextoObligatorio(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " es obligatorio."
            );
        }
    }

    @Override
    public String toString() {
        return "Detalle [" + id + "]"
                + " | Tipo: " + tipoArticulo
                + " | Artículo: " + descripcion
                + " | Cantidad: " + cantidad
                + " | Precio unitario: S/ "
                + String.format("%.2f", precioUnitario)
                + " | Subtotal: S/ "
                + String.format("%.2f", calcularSubtotal());
    }
}

