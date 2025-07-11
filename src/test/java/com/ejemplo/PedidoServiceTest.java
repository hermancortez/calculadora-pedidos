package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PedidoServiceTest {

    // 1. Declarar un mock para DescuentoRepository
    @Mock
    private DescuentoRepository mockDescuentoRepository; // Asumiendo que esta clase existe

    // 2. Inyectar los mocks en la instancia de PedidoService
    // Esto creará una instancia de PedidoService y le pasará mockDescuentoRepository
    @InjectMocks
    private PedidoService servicio;

    // 3. Configurar los mocks antes de cada test
    @BeforeEach
    void setUp() {
        // Inicializa todos los mocks anotados con @Mock y @InjectMocks
        MockitoAnnotations.openMocks(this);

        // Opcional: Si PedidoService.calcularTotal ahora usa DescuentoRepository,
        // podrías necesitar configurar el comportamiento del mock aquí.
        // Por ejemplo, si tu PedidoService necesita un descuento del repository:
        // when(mockDescuentoRepository.obtenerDescuento("WELCOME")).thenReturn(0.15);
        // Ajusta esto según cómo tu PedidoService use DescuentoRepository.
        // Si tu calcularTotal sigue siendo el mismo que me mostraste (sin usar el repository),
        // entonces el mock solo sirve para que el constructor compile.
    }

    @Test
    void testSinDescuentoNiEnvioNormal() {
        // subtotal = 100.0, aplicaDescuento = false, envioExpress = false
        // descuento = 0
        // envio = 10.0
        // total = (100.0 * (1 - 0)) + 10.0 = 100.0 + 10.0 = 110.0
        double total = servicio.calcularTotal(100.0, false, false);
        assertEquals(110.0, total); // ESTE YA ESTABA CORRECTO
    }

    @Test
    void testConDescuentoYEnvioExpress() {
        // subtotal = 100.0, aplicaDescuento = true, envioExpress = true
        // descuento = 0.1
        // envio = 20.0
        // total = (100.0 * (1 - 0.1)) + 20.0 = (100.0 * 0.9) + 20.0 = 90.0 + 20.0 = 110.0
        double total = servicio.calcularTotal(100.0, true, true);
        assertEquals(110.0, total); // CORREGIDO: Antes 100.0
    }

    @Test
    void testConDescuentoYEnvioNormal() {
        // subtotal = 200.0, aplicaDescuento = true, envioExpress = false
        // descuento = 0.1
        // envio = 10.0
        // total = (200.0 * (1 - 0.1)) + 10.0 = (200.0 * 0.9) + 10.0 = 180.0 + 10.0 = 190.0
        double total = servicio.calcularTotal(200.0, true, false);
        assertEquals(190.0, total); // ESTE YA ESTABA CORRECTO
    }

    @Test
    void testSinDescuentoYEnvioExpress() {
        // subtotal = 150.0, aplicaDescuento = false, envioExpress = true
        // descuento = 0
        // envio = 20.0
        // total = (150.0 * (1 - 0)) + 20.0 = 150.0 + 20.0 = 170.0
        double total = servicio.calcularTotal(150.0, false, true);
        assertEquals(170.0, total); // ESTE YA ESTABA CORRECTO
    }

}
