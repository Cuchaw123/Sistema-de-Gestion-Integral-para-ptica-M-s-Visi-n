package main.java.optica.model;

public class Lente {

    private String id;

    // Marca o fabricante. Ej.: "Essilor", "ZEISS", "HOYA", "Genérico"
    private String marca;

    // Material de fabricación.
    // Ej.: "Policarbonato", "Resina índice 1.56", "Mineral"
    private String material;

    // Diseño óptico. Ej.: "Monofocal", "Bifocal", "Progresivo"
    private String tipoDiseño;

    // Tratamiento o tecnología adicional.
    // Ej.: "Antirreflejante", "Filtro de luz azul", "Fotocromático"
    private String tratamiento;

    private double precioBase;
    private int stock;

    // Constructor completo utilizado por LenteBuilder
    public Lente(
            String id,
            String marca,
            String material,
            String tipoDiseño,
            String tratamiento,
            double precioBase,
            int stock
    ) {
        setId(id);
        setMarca(marca);
        setMaterial(material);
        setTipoDiseño(tipoDiseño);
        setTratamiento(tratamiento);
        setPrecioBase(precioBase);
        setStock(stock);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    "El identificador del lente es obligatorio."
            );
        }

        this.id = id.trim();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException(
                    "La marca del lente es obligatoria."
            );
        }

        this.marca = marca.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material == null || material.isBlank()) {
            throw new IllegalArgumentException(
                    "El material del lente es obligatorio."
            );
        }

        this.material = material.trim();
    }

    public String getTipoDiseño() {
        return tipoDiseño;
    }

    public void setTipoDiseño(String tipoDiseño) {
        if (tipoDiseño == null || tipoDiseño.isBlank()) {
            throw new IllegalArgumentException(
                    "El tipo de diseño del lente es obligatorio."
            );
        }

        this.tipoDiseño = tipoDiseño.trim();
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        if (tratamiento == null || tratamiento.isBlank()) {
            throw new IllegalArgumentException(
                    "El tratamiento del lente es obligatorio."
            );
        }

        this.tratamiento = tratamiento.trim();
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (Double.isNaN(precioBase) || Double.isInfinite(precioBase)) {
            throw new IllegalArgumentException(
                    "El precio debe ser un número válido."
            );
        }

        if (precioBase < 0) {
            throw new IllegalArgumentException(
                    "El precio base del lente no puede ser negativo."
            );
        }

        this.precioBase = precioBase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException(
                    "El stock del lente no puede ser negativo."
            );
        }

        this.stock = stock;
    }

    // Comprueba si existe al menos una unidad disponible
    public boolean hayStock() {
        return stock > 0;
    }

    // Comprueba si existe la cantidad solicitada
    public boolean hayStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad consultada debe ser mayor que cero."
            );
        }

        return stock >= cantidad;
    }

    // Agrega unidades al inventario
    public void aumentarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad que se agregará debe ser mayor que cero."
            );
        }

        stock += cantidad;
    }

    // Retira unidades al vender o utilizar lentes en un pedido
    public void disminuirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad que se retirará debe ser mayor que cero."
            );
        }

        if (!hayStock(cantidad)) {
            throw new IllegalStateException(
                    "Stock insuficiente de lentes. Disponible: "
                            + stock + ", solicitado: " + cantidad + "."
            );
        }

        stock -= cantidad;
    }

    // Permite identificar lentes próximos a agotarse
    public boolean tieneStockBajo(int limite) {
        if (limite < 0) {
            throw new IllegalArgumentException(
                    "El límite de stock no puede ser negativo."
            );
        }

        return stock <= limite;
    }

    // Devuelve una descripción breve de sus características ópticas
    public String obtenerCaracteristicas() {
        return tipoDiseño
                + " | " + material
                + " | " + tratamiento;
    }

    // Calcula el valor económico del stock disponible
    public double calcularValorInventario() {
        return precioBase * stock;
    }

    @Override
    public String toString() {
        return "Lente [" + id + "]"
                + " | Marca: " + marca
                + " | Diseño: " + tipoDiseño
                + "\n  Material: " + material
                + " | Tratamiento: " + tratamiento
                + "\n  Precio base: S/ " + String.format("%.2f", precioBase)
                + " | Stock: " + stock + " unidades";
    }
}