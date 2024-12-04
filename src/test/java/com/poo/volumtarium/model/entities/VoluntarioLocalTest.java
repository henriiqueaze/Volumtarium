package com.poo.volumtarium.model.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VoluntarioLocalTest {

    @Test
    public void testInscreverEmOportunidade() {
        ONG ong = new ONG(1, "Sociau", "Rua Central", "Educação", "ONG de apoio educacional", "contato@sociau.com");
        Oportunidade oportunidade = new Oportunidade(1, "Aulas de reforço", "Experiência em ensino", ong);

        VoluntarioLocal voluntario = new VoluntarioLocal(1, "Arthur", 18, "São Bento", "567890123");
        voluntario.inscreverEmOportunidade(oportunidade);

        assertEquals(1, oportunidade.getVoluntariosInscritos().size());
        assertEquals("Arthur", oportunidade.getVoluntariosInscritos().get(0).getNome());
    }
}
