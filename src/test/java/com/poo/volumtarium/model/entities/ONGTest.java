package com.poo.volumtarium.model.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ONGTest {

    @Test
    public void testCriarONG() {
        ONG ong = new ONG(1, "Sociau", "Rua Central", "Educação", "ONG de apoio educacional", "contato@sociau.com");

        assertEquals(1, ong.getId());
        assertEquals("Sociau", ong.getNome());
        assertEquals("Rua Central", ong.getEndereco());
        assertEquals("Educação", ong.getAreaAtuacao());
        assertEquals("ONG de apoio educacional", ong.getDescricao());
        assertEquals("contato@sociau.com", ong.getContato());
    }

    @Test
    public void testAdicionarOportunidade() {
        ONG ong = new ONG(1, "Sociau", "Rua Central", "Educação", "ONG de apoio educacional", "contato@sociau.com");
        Oportunidade oportunidade = new Oportunidade(1, "Aulas de reforço", "Ensino", ong);

        ong.adicionarOportunidade(oportunidade);

        assertEquals(1, ong.getOportunidades().size());
        assertEquals("Aulas de reforço", ong.getOportunidades().get(0).getDescricao());
    }
}
