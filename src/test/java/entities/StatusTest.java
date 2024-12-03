package test.java.entities;

import entities.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {

    @Test
    void testEnumValues() {
        Status[] valoresEsperados = {Status.PENDENTE, Status.ACEITA, Status.RECUSADA};
        assertArrayEquals(valoresEsperados, Status.values());
    }

    @Test
    void testValueOf() {
        assertEquals(Status.PENDENTE, Status.valueOf("PENDENTE"));
        assertEquals(Status.ACEITA, Status.valueOf("ACEITA"));
        assertEquals(Status.RECUSADA, Status.valueOf("RECUSADA"));
    }

    @Test
    void testInvalidValueOf() {
        // Verifica se uma tentativa de valor inválido lança uma exceção
        assertThrows(IllegalArgumentException.class, () -> Status.valueOf("INEXISTENTE"));
    }
}
