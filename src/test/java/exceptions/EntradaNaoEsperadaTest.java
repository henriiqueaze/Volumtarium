package test.java.exceptions;

import Exceptions.EntradaNaoEsperada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntradaNaoEsperadaTest {

    @Test
    void testConstrutorEGetMessage() {
        EntradaNaoEsperada exception = new EntradaNaoEsperada("Erro na entrada!");

        assertEquals("Erro na entrada!", exception.getMessage());
    }

    @Test
    void testMessage() {
        EntradaNaoEsperada exception = new EntradaNaoEsperada("Erro na entrada!");

        assertEquals("Entrada Inesperada! Favor, tente novamente.", exception.message());
    }

    @Test
    void testLancarExcecao() {
        EntradaNaoEsperada exception = assertThrows(EntradaNaoEsperada.class, () -> {
            throw new EntradaNaoEsperada("Erro na entrada!");
        });

        assertEquals("Erro na entrada!", exception.getMessage());
    }
}
