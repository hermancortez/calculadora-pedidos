package com.ejemplo;

public class DescuentoRepository {
    
    public double obtenerPorcentaje(String codigo) {
        // === CORRECCIÓN: Añadir una verificación para null al inicio ===
        if (codigo == null) {
            return 0.0; // Si el código es null, no hay descuento. Esto evita el NullPointerException.
        }

        if (codigo.equals("PROMO10")) {
            return 0.10;
        }
        return 0.0;
    }
}
