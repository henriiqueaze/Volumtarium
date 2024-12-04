package com.poo.volumtarium.model.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VoluntarioTest {

    @Test
    public void testCriarVoluntarioLocal() {
        VoluntarioLocal voluntario = new VoluntarioLocal(1, "Ana", 30, "Centro", "321654987");

        assertEquals(1, voluntario.getId());
        assertEquals("Ana", voluntario.getNome());
        assertEquals(30, voluntario.getIdade());
        assertEquals("Centro", voluntario.getLocalizacao());
        assertEquals("321654987", voluntario.getContato());
    }

    @Test
    public void testInscricaoEmOportunidadeComoLocal() {
        ONG ong = new ONG(1, "Ajuda Todos", "Rua 10", "Saúde", "ONG na área de saúde", "contato@ajuda.com");
        Oportunidade oportunidade = new Oportunidade(1, "Assistência Médica", "Formação em saúde", ong);
        VoluntarioLocal voluntario = new VoluntarioLocal(1, "José", 28, "Zona Sul", "889977665");

        voluntario.inscreverEmOportunidade(oportunidade);

        assertEquals(1, oportunidade.getVoluntariosInscritos().size());
        assertEquals("José", oportunidade.getVoluntariosInscritos().get(0).getNome());
    }
}
