package com.poo.volumtarium.model.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FaltandoCampoExceptionTest {

    @Test
    void testFaltandoCampoExceptionMessage() {
        String mensagem = "Campo obrigatório está faltando!";
        FaltandoCampoException exception = new FaltandoCampoException(mensagem);
        assertEquals(mensagem, exception.getMessage());
    }
}
