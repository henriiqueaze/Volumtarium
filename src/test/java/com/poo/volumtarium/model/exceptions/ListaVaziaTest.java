package com.poo.volumtarium.model.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListaVaziaTest {

    @Test
    void testListaVaziaMessage() {
        String mensagem = "Nenhum item na lista.";
        ListaVazia exception = new ListaVazia(mensagem);
        assertEquals(mensagem, exception.getMessage());
    }

    @Test
    void testListaVaziaCustomMessage() {
        ListaVazia exception = new ListaVazia("Erro!");
        assertEquals("A lista encontra-se vazia.", exception.message());
    }
}
