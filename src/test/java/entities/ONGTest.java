package test.java.entities;

import entities.ONG;
import entities.Oportunidade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ONGTest {

    private ONG ongSocial;

    @BeforeEach
    void setupOng() {
        ongSocial = new ONG(101, "ONG Social", "Rua das Flores, 123", "Assistência Social", "ONG focada em projetos sociais", "contato@ongsocial.org");
    }

    @Test
    void deveAdicionarOportunidadeComSucesso() {
        Oportunidade oportunidadeAssistencia = new Oportunidade(1, "Apoio em projetos de inclusão", "Disponibilidade para trabalhar 2 horas por semana", "São Paulo", 101);
        ongSocial.adicionarOportunidade(oportunidadeAssistencia);

        List<Oportunidade> oportunidades = ongSocial.listarOportunidades();
        assertEquals(1, oportunidades.size(), "Deve adicionar a oportunidade com sucesso.");
        assertTrue(oportunidades.contains(oportunidadeAssistencia), "A oportunidade adicionada deve estar na lista.");
    }

    @Test
    void deveRemoverOportunidadeComSucesso() {
        Oportunidade oportunidadeAssistencia = new Oportunidade(1, "Apoio em projetos de inclusão", "Disponibilidade para trabalhar 2 horas por semana", "São Paulo", 101);
        ongSocial.adicionarOportunidade(oportunidadeAssistencia);

        ongSocial.removerOportunidade(oportunidadeAssistencia);

        List<Oportunidade> oportunidades = ongSocial.listarOportunidades();
        assertTrue(oportunidades.isEmpty(), "A lista de oportunidades deve estar vazia após remoção.");
    }

    @Test
    void deveListarTodasOportunidades() {
        Oportunidade oportunidadeAssistencia1 = new Oportunidade(1, "Apoio em projetos de inclusão", "Disponibilidade para trabalhar 2 horas por semana", "São Paulo", 101);
        Oportunidade oportunidadeAssistencia2 = new Oportunidade(2, "Apoio a crianças em situação de vulnerabilidade", "Empatia e interesse por causas sociais", "Rio de Janeiro", 101);

        ongSocial.adicionarOportunidade(oportunidadeAssistencia1);
        ongSocial.adicionarOportunidade(oportunidadeAssistencia2);

        List<Oportunidade> oportunidades = ongSocial.listarOportunidades();
        assertEquals(2, oportunidades.size(), "Deve listar duas oportunidades.");
        assertTrue(oportunidades.contains(oportunidadeAssistencia1), "A primeira oportunidade deve estar na lista.");
        assertTrue(oportunidades.contains(oportunidadeAssistencia2), "A segunda oportunidade deve estar na lista.");
    }

    @Test
    void deveRetornarValoresCorretosDosGetters() {
        assertEquals(101, ongSocial.getId(), "ID incorreto.");
        assertEquals("ONG Social", ongSocial.getNome(), "Nome incorreto.");
        assertEquals("Rua das Flores, 123", ongSocial.getEndereco(), "Endereço incorreto.");
        assertEquals("Assistência Social", ongSocial.getAreaAtuacao(), "Área de atuação incorreta.");
        assertEquals("ONG focada em projetos sociais", ongSocial.getDescricao(), "Descrição incorreta.");
        assertEquals("contato@ongsocial.org", ongSocial.getContato(), "Contato incorreto.");
        assertNotNull(ongSocial.getOportunidades(), "A lista de oportunidades não deve ser nula.");
        assertTrue(ongSocial.getOportunidades().isEmpty(), "A lista de oportunidades deve estar vazia inicialmente.");
    }
}
