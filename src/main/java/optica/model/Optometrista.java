package main.java.optica.model;

public class Optometrista {

    private String id;
    private String nombre;
    private String apellido;

    // Ej.: "Optometría general", "Contactología", "Baja visión"
    private String areaAtencion;

    // Código o registro profesional correspondiente
    private String numeroRegistroProfesional;

    // Indica si puede recibir nuevas citas
    private boolean disponible;

    public Optometrista(
            String id,
            String nombre,
            String apellido,
            String areaAtencion,
            String numeroRegistroProfesional,
            boolean disponible
    ) {
        setId(id);
        setNombre(nombre);
        setApellido(apellido);
        setAreaAtencion(areaAtencion);
        setNumeroRegistroProfesional(numeroRegistroProfesional);
        setDisponible(disponible);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        validarTextoObligatorio(id, "identificador");
        this.id = id.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarNombre(nombre, "nombre");
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        validarNombre(apellido, "apellido");
        this.apellido = apellido.trim();
    }

    public String getAreaAtencion() {
        return areaAtencion;
    }

    public void setAreaAtencion(String areaAtencion) {
        validarTextoObligatorio(areaAtencion, "área de atención");
        this.areaAtencion = areaAtencion.trim();
    }

    public String getNumeroRegistroProfesional() {
        return numeroRegistroProfesional;
    }

    public void setNumeroRegistroProfesional(
            String numeroRegistroProfesional
    ) {
        validarTextoObligatorio(
                numeroRegistroProfesional,
                "número de registro profesional"
        );

        this.numeroRegistroProfesional =
                numeroRegistroProfesional.trim();
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String obtenerNombreCompleto() {
        return nombre + " " + apellido;
    }

    public void marcarDisponible() {
        disponible = true;
    }

    public void marcarNoDisponible() {
        disponible = false;
    }

    public boolean puedeRecibirCitas() {
        return disponible;
    }

    private void validarTextoObligatorio(
            String valor,
            String campo
    ) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " es obligatorio."
            );
        }
    }

    private void validarNombre(
            String valor,
            String campo
    ) {
        validarTextoObligatorio(valor, campo);

        if (!valor.matches("[\\p{L} .'-]+")) {
            throw new IllegalArgumentException(
                    "El " + campo + " solo puede contener letras."
            );
        }
    }

    @Override
    public String toString() {
        String estado = disponible
                ? "DISPONIBLE"
                : "NO DISPONIBLE";

        return "Optometrista [" + id + "]"
                + " | Nombre: " + obtenerNombreCompleto()
                + " | Área: " + areaAtencion
                + " | Registro profesional: "
                + numeroRegistroProfesional
                + " | Estado: " + estado;
    }
}