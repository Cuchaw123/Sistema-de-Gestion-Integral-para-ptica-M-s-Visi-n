package main.java.optica.model;


public class Rol {

    private String id;
    private String nombre;        // Ej: "ADMINISTRADOR", "CAJERO", "OPTOMETRA"
    private String descripcion;   // Ej: "Acceso total", "Gestión de cobros y caja", "Lectura y registro de recetas"
    private boolean estado;       // true = Activo, false = Suspendido

    // Constructor completo (será invocado por el RolBuilder)
    public Rol(String id, String nombre, String descripcion, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Rol [" + id + "] " + nombre + " | Estado: " + (estado ? "Activo" : "Inactivo") +
                "\n  Permisos: " + descripcion;
    }
}