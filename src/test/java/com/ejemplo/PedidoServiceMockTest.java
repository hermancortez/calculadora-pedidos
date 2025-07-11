package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class PedidoServiceMockTest {
    

    @Test
    void testConMockDeDescuento() {
        DescuentoRepository mockRepo = mock(DescuentoRepository.class);
        when(mockRepo.obtenerPorcentaje("PROMO10")).thenReturn(0.10);
        PedidoService service = new PedidoService(mockRepo);
        double total = service.calcularTotal(100, "PROMO10", true);
        assertEquals(110.0, total); // 100 - 10% + 20
    }

    @Test
    void testConMockDeDescuentoSinEnvioExpress() {
        DescuentoRepository mockRepo = mock(DescuentoRepository.class);
        when(mockRepo.obtenerPorcentaje("PROMO10")).thenReturn(0.10);
        PedidoService service = new PedidoService(mockRepo);
        double total = service.calcularTotal(200, "PROMO10", false);
        assertEquals(190.0, total); // 200 - 10% + 10
    }
}
