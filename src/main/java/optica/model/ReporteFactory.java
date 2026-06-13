package main.java.optica.model;

import java.time.LocalDateTime;
import java.util.UUID;


public class ReporteFactory {


    public static Reporte generarPlantillaReporte(String criterio, String usuario) {

        // Código único de auditoría para el seguimiento del sistema
        String idGenerado = "REP-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        if (criterio.equalsIgnoreCase("CAJA")) {
            return new ReporteBuilder()
                    .setId(idGenerado)
                    .setTipoReporte("CIERRE_CAJA_DIARIO")
                    .setUsuarioGenerador(usuario)
                    .setTotalTransacciones(0) // Se calculará dinámicamente en el Service
                    .setMontoTotalSoles(0.0)  // Se calculará dinámicamente en el Service
                    .setContenidoDetalle("INFORME FINANCIERO: Consolidado de ventas, cobros por tarjeta, efectivo y billeteras digitales.")
                    .setFechaGeneracion(LocalDateTime.now())
                    .build();

        } else if (criterio.equalsIgnoreCase("INVENTARIO")) {
            return new ReporteBuilder()
                    .setId(idGenerado)
                    .setTipoReporte("STOCK_CRITICO_ALMACEN")
                    .setUsuarioGenerador(usuario)
                    .setTotalTransacciones(0)
                    .setMontoTotalSoles(0.0) // No aplica montos directos
                    .setContenidoDetalle("INFORME DE STOCK: Alerta de armazones, cristales y accesorios con cantidades menores al mínimo permitido.")
                    .setFechaGeneracion(LocalDateTime.now())
                    .build();
        }

        // Reporte general por defecto
        return new ReporteBuilder()
                .setId(idGenerado)
                .setTipoReporte("AUDITORIA_GENERAL")
                .setUsuarioGenerador(usuario)
                .setContenidoDetalle("Reporte misceláneo del estado del sistema.")
                .setFechaGeneracion(LocalDateTime.now())
                .build();
    }
}