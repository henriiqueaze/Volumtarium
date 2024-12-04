package com.poo.volumtarium.model.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class OportunidadeTest {

    @Test
    public void testInscreverVoluntario() {
        ONG ong = new ONG(1, "Sociau", "Rua Central", "Educação", "ONG de apoio educacional", "contato@sociau.com");
        Oportunidade oportunidade = new Oportunidade(1, "Aulas de reforço", "Experiência em ensino", ong);

        Voluntario voluntario = new VoluntarioLocal(1, "Lucas", 24, "Santa Luzia", "123456789");

        oportunidade.inscreverVoluntario(voluntario);

        List<Voluntario> inscritos = oportunidade.getVoluntariosInscritos();
        assertEquals(1, inscritos.size());
        assertEquals("Lucas", inscritos.get(0).getNome());
    }

    @Test
    public void testListarVoluntariosInscritos() {
        ONG ong = new ONG(1, "Sociau", "Rua Central", "Educação", "ONG de apoio educacional", "contato@sociau.com");
        Oportunidade oportunidade = new Oportunidade(1, "Aulas de reforço", "Experiência em ensino", ong);

        Voluntario voluntario1 = new VoluntarioLocal(1, "Henrique", 20, "São Bento", "987654321");
        Voluntario voluntario2 = new VoluntarioRemoto(2, "Thiago", 26, "Santa Luzia", "112233445");

        oportunidade.inscreverVoluntario(voluntario1);
        oportunidade.inscreverVoluntario(voluntario2);

        List<Voluntario> inscritos = oportunidade.getVoluntariosInscritos();
        assertEquals(2, inscritos.size());
        assertEquals("Henrique", inscritos.get(0).getNome());
        assertEquals("Thiago", inscritos.get(1).getNome());
    }
}
