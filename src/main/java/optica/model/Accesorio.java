package main.java.optica.model;


    public class Accesorio implements ProductoOptico {
        private String id;
        private String nombre;
        private double precio;

        // Constructor que usa el Builder
        public Accesorio(String id, String nombre, double precio) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
        }

        @Override
        public void mostrarDetalles() {
            System.out.println("Accesorio: " + nombre + " | Precio: S/." + precio);
        }

        public String getId() { return id; }
        public String getNombre() { return nombre; }
        public double getPrecio() { return precio; }
    }
