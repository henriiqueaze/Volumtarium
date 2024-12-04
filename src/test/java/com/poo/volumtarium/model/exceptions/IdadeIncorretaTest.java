package com.poo.volumtarium.model.exceptions;

import com.poo.volumtarium.model.exceptions.IdadeIncorreta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdadeIncorretaTest {

    @Test
    void testConstrutorEGetMessage() {
        IdadeIncorreta exception = new IdadeIncorreta("Idade inválida para cadastro!");

        assertEquals("Idade inválida para cadastro!", exception.getMessage());
    }

    @Test
    void testMessage() {
        IdadeIncorreta exception = new IdadeIncorreta("Idade inválida para cadastro!");

        assertEquals("Idade não permitida para o cadastramento na oportunidade.", exception.message());
    }

    @Test
    void testLancarExcecao() {
        IdadeIncorreta exception = assertThrows(IdadeIncorreta.class, () -> {
            throw new IdadeIncorreta("Idade inválida para cadastro!");
        });

        assertEquals("Idade inválida para cadastro!", exception.getMessage());
    }
}
