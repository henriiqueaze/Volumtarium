package test.java.entities;

import entities.Oportunidade;
import entities.Voluntario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OportunidadeTest {

    private Oportunidade oportunidade;

    @BeforeEach
    void setUp() {
        oportunidade = new Oportunidade(1, "Apoio a abrigos de animais", "Cuidados básicos com animais", "Santa Luzia, PB", 101);
    }

    @Test
    void testGetters() {
        assertEquals(1, oportunidade.getId());
        assertEquals("Apoio a abrigos de animais", oportunidade.getDescricao());
        assertEquals("Cuidados básicos com animais", oportunidade.getRequisitos());
        assertEquals("Santa Luzia, PB", oportunidade.getLocalizacao());
        assertEquals(101, oportunidade.getIdONG());
        assertNotNull(oportunidade.getVoluntariosInscritos());
        assertTrue(oportunidade.getVoluntariosInscritos().isEmpty());
    }

    @Test
    void testInscreverVoluntario() {
        Voluntario voluntario = new Voluntario(1, "Dr. Henrique", 18, "São Bento, PB", "Apaixonado por animais", "henrique@animais.com");
        oportunidade.inscreverVoluntario(voluntario);

        List<Voluntario> voluntarios = oportunidade.listarVoluntariosInscritos();
        assertEquals(1, voluntarios.size());
        assertEquals(voluntario, voluntarios.get(0));
    }

    @Test
    void testListarVoluntariosInscritos() {
        Voluntario voluntario1 = new Voluntario(1, "Dr. Henrique", 18, "São Bento, PB", "Apaixonado por animais", "henrique@animais.com");
        Voluntario voluntario2 = new Voluntario(2, "Arthur", 27, "Santa Luzia, PB", "Cuidador de cães", "arthur@animais.com");

        oportunidade.inscreverVoluntario(voluntario1);
        oportunidade.inscreverVoluntario(voluntario2);

        List<Voluntario> voluntarios = oportunidade.listarVoluntariosInscritos();
        assertEquals(2, voluntarios.size());
        assertTrue(voluntarios.contains(voluntario1));
        assertTrue(voluntarios.contains(voluntario2));
    }

    @Test
    void testAdicionarVoluntariosDuplicados() {
        Voluntario voluntario = new Voluntario(1, "Lucas", 24, "Santa Luzia, PB", "Apaixonado por animais", "lucas@animais.com");
        oportunidade.inscreverVoluntario(voluntario);
        oportunidade.inscreverVoluntario(voluntario);

        List<Voluntario> voluntarios = oportunidade.listarVoluntariosInscritos();
        assertEquals(2, voluntarios.size());
    }
}
