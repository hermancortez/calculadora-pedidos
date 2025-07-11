package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DescuentoRepositoryTest {

        // Instancia de la clase a probar
    DescuentoRepository repository = new DescuentoRepository();

    @Test
    void testObtenerPorcentajeConPromo10() {
        // Prueba cuando el código es "PROMO10"
        double porcentaje = repository.obtenerPorcentaje("PROMO10");
        assertEquals(0.10, porcentaje, 0.0001); // Se espera un 10%
    }

    @Test
    void testObtenerPorcentajeConOtroCodigo() {
        // Prueba cuando el código es diferente de "PROMO10"
        double porcentaje = repository.obtenerPorcentaje("OTROCODIGO");
        assertEquals(0.0, porcentaje, 0.0001); // Se espera 0.0
    }

    @Test
    void testObtenerPorcentajeConCodigoVacio() {
        // Prueba cuando el código es una cadena vacía
        double porcentaje = repository.obtenerPorcentaje("");
        assertEquals(0.0, porcentaje, 0.0001); // Se espera 0.0
    }

    @Test
    void testObtenerPorcentajeConCodigoNulo() {
        // Prueba cuando el código es nulo.
        // Asumiendo que la implementación de DescuentoRepository maneja null sin lanzar NullPointerException,
        // y devuelve 0.0.
        // Si tu implementación original no manejaba null y lanzaba NPE, este test fallaría.
        // La versión corregida en el historial de conversación maneja null.
        double porcentaje = repository.obtenerPorcentaje(null);
        assertEquals(0.0, porcentaje, 0.0001); // Se espera 0.0
    }
}
