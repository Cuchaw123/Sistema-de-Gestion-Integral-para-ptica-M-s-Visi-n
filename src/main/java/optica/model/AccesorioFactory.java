package main.java.optica.model;

public class AccesorioFactory {


    public static Accesorio crearAccesorio(String tipo) {

        if (tipo.equalsIgnoreCase("ESTUCHE")) {
            return new Accesorio("EST-01", "Estuche Rígido Premium", 25.00);

        } else if (tipo.equalsIgnoreCase("LIQUIDO")) {
            return new Accesorio("LIQ-01", "Líquido de Lentes 500ml", 35.50);

        } else if (tipo.equalsIgnoreCase("PAÑO")) {
            return new Accesorio("PAN-01", "Paño de Microfibra Antiempañante", 8.00);

        } else if (tipo.equalsIgnoreCase("CORDON")) {
            return new Accesorio("COR-01", "Cordón Deportivo Ajustable", 12.00);
        }

        // Accesorio por defecto si no coincide ninguno
        return new Accesorio("GEN-00", "Accesorio Genérico", 10.00);
    }
}
