package com.ejemplo;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    
    @Test
    void testMainMethodDoesNotThrowException() {
        // Prueba que el método main se ejecuta sin lanzar excepciones
        // Esto es útil para cubrir la línea del main, aunque no se pruebe la salida de la consola directamente.
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}
