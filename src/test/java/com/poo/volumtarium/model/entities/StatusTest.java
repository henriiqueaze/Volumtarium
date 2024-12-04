package com.poo.volumtarium.model.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatusTest {

    @Test
    public void testValoresStatus() {
        Status pendente = Status.PENDENTE;
        Status aceita = Status.ACEITA;
        Status recusada = Status.RECUSADA;

        assertEquals("PENDENTE", pendente.name());
        assertEquals("ACEITA", aceita.name());
        assertEquals("RECUSADA", recusada.name());

        assertEquals(0, pendente.ordinal());
        assertEquals(1, aceita.ordinal());
        assertEquals(2, recusada.ordinal());
    }
}
