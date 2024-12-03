package test.java.entities;

import entities.Voluntario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoluntarioTest {

    private Voluntario voluntario;

    @BeforeEach
    void setUp() {
        voluntario = new Voluntario(1, "Thiago Porto", 20, "Santa Luzia", "Proativo e dedicado", "thiago.porto@gmail.com");
    }

    @Test
    void testGetId() {
        assertEquals(1, voluntario.getId());
    }

    @Test
    void testGetNome() {
        assertEquals("Thiago Porto", voluntario.getNome());
    }

    @Test
    void testGetIdade() {
        assertEquals(20, voluntario.getIdade());
    }

    @Test
    void testGetLocalizacao() {
        assertEquals("Santa Luzia", voluntario.getLocalizacao());
    }

    @Test
    void testGetPerfil() {
        assertEquals("Proativo e dedicado", voluntario.getPerfil());
    }

    @Test
    void testGetContato() {
        assertEquals("thiago.porto@gmail.com", voluntario.getContato());
    }

    @Test
    void testCriarVoluntarioComDadosInvalidos() {
        Voluntario voluntarioInvalido = new Voluntario(-1, "", -5, "", "", "");

        assertEquals(-1, voluntarioInvalido.getId());
        assertEquals("", voluntarioInvalido.getNome());
        assertEquals(-5, voluntarioInvalido.getIdade());
        assertEquals("", voluntarioInvalido.getLocalizacao());
        assertEquals("", voluntarioInvalido.getPerfil());
        assertEquals("", voluntarioInvalido.getContato());
    }
}
