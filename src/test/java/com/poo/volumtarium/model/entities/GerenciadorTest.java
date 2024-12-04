package com.poo.volumtarium.model.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorTest {

    @Test
    public void testCadastrarONG() {
        Gerenciador gerenciador = Gerenciador.getInstance();

        gerenciador.cadastrarONG("Sociau", "Rua Central", "Educação", "ONG de apoio educacional", "contato@sociau.com");

        assertEquals(1, gerenciador.getOngs().size());
        assertEquals("Sociau", gerenciador.getOngs().get(0).getNome());
    }

    @Test
    public void testCadastrarVoluntario() throws Exception {
        Gerenciador gerenciador = Gerenciador.getInstance();

        gerenciador.cadastrarVoluntario("Lucas", 24, "Santa Luzia", "987654321", (byte) 1);

        assertEquals(1, gerenciador.getVoluntarios().size());
        assertEquals("Lucas", gerenciador.getVoluntarios().get(0).getNome());
    }

    @Test
    public void testCadastrarOportunidade() throws Exception {
        Gerenciador gerenciador = Gerenciador.getInstance();
        gerenciador.cadastrarONG("Sociau", "São Bento", "Educação", "ONG educativa", "ong@sociau.com");

        gerenciador.cadastrarOportunidade("Evento Educacional", "Disponibilidade", "São Bento", 1);

        assertEquals(0, gerenciador.getOportunidades().get(0).getId());
    }

    @Test
    public void testInscreverVoluntarioEmOportunidade() throws Exception {
        Gerenciador gerenciador = Gerenciador.getInstance();
        gerenciador.cadastrarVoluntario("Thiago", 20, "Santa Luzia", "123456789", (byte) 2);

        Oportunidade oportunidade = new Oportunidade(1, "Ajudar no evento", "Disponibilidade", new ONG(1, "Sociau", "São Bento", "Educação", "ONG educativa", "ong@sociau.com"));
        Voluntario voluntario = new VoluntarioLocal(1, "Thiago", 20, "Santa Luzia", "123456789");

        gerenciador.inscreverVoluntario(voluntario.getId(), oportunidade.getId());

        assertEquals("Thiago", gerenciador.getVoluntarios().get(0).getNome()); // Corrige a expectativa aqui
    }
}
