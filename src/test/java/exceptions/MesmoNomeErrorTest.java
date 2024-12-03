package test.java.exceptions;

import Exceptions.MesmoNomeError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MesmoNomeErrorTest {

    @Test
    void testConstrutorEGetMessage() {
        // Testa se a exceção é lançada corretamente com a mensagem fornecida
        MesmoNomeError exception = new MesmoNomeError("Nome da ONG já registrado!");

        assertEquals("Nome da ONG já registrado!", exception.getMessage());
    }

    @Test
    void testMessage() {
        // Testa se o método 'message' retorna a mensagem esperada
        MesmoNomeError exception = new MesmoNomeError("Nome da ONG já registrado!");

        assertEquals("Já existe uma ONG com esse nome.", exception.message());
    }

    @Test
    void testLancarExcecao() {
        // Testa se a exceção é realmente lançada quando chamada
        MesmoNomeError exception = assertThrows(MesmoNomeError.class, () -> {
            throw new MesmoNomeError("Nome da ONG já registrado!");
        });

        assertEquals("Nome da ONG já registrado!", exception.getMessage());
    }
}
