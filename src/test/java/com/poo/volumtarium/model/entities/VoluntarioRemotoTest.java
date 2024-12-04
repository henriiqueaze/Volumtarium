package com.poo.volumtarium.model.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VoluntarioRemotoTest {

    @Test
    public void testCriarVoluntarioRemoto() {
        VoluntarioRemoto voluntario = new VoluntarioRemoto(2, "Joana", 35, "Online", "987654321");

        assertEquals(2, voluntario.getId());
        assertEquals("Joana", voluntario.getNome());
        assertEquals(35, voluntario.getIdade());
        assertEquals("Online", voluntario.getLocalizacao());
        assertEquals("987654321", voluntario.getContato());
    }

    @Test
    public void testInscricaoEmOportunidade() {
        ONG ong = new ONG(2, "ONG Virtual", "Rua Virtual", "Tecnologia", "ONG para projetos tecnológicos", "virtual@ong.com");
        Oportunidade oportunidade = new Oportunidade(2, "Desenvolvimento Web", "Conhecimento em programação", ong);
        VoluntarioRemoto voluntario = new VoluntarioRemoto(2, "Joana", 35, "Online", "987654321");

        voluntario.inscreverEmOportunidade(oportunidade);

        assertEquals(1, oportunidade.getVoluntariosInscritos().size());
        assertEquals("Joana", oportunidade.getVoluntariosInscritos().get(0).getNome());
    }
}
