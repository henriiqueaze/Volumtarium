package com.poo.volumtarium.controllers;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.poo.volumtarium.controllers.CadastrarONGController;
import com.poo.volumtarium.model.entities.Gerenciador;
import com.poo.volumtarium.model.entities.ONG;
import com.poo.volumtarium.model.exceptions.FaltandoCampoException;
import com.poo.volumtarium.utils.ValidacaoUtils;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class CadastrarONGControllerTest {

    @Mock
    private Gerenciador gerenciador;

    @InjectMocks
    private CadastrarONGController cadastrarONGController;

    private TextField nomeField;
    private TextField contatoField;
    private TextField enderecoField;
    private TextField atuacaoField;
    private TextField descricaoField;

    @BeforeEach
    public void setUp() {
        nomeField = mock(TextField.class);
        contatoField = mock(TextField.class);
        enderecoField = mock(TextField.class);
        atuacaoField = mock(TextField.class);
        descricaoField = mock(TextField.class);
    }

    @Test
    public void testCadastrarONGComSucesso() throws FaltandoCampoException {
        when(nomeField.getText()).thenReturn("ONG Teste");
        when(contatoField.getText()).thenReturn("contato@ong.com");
        when(enderecoField.getText()).thenReturn("Rua Teste");
        when(atuacaoField.getText()).thenReturn("Educação");
        when(descricaoField.getText()).thenReturn("Descrição da ONG");

        cadastrarONGController.onSalvarAction();

        verify(gerenciador).addOng(any(ONG.class));
    }

    @Test
    public void testCadastrarONGComCamposVazios() {
        when(nomeField.getText()).thenReturn("");
        when(contatoField.getText()).thenReturn("");
        when(enderecoField.getText()).thenReturn("");
        when(atuacaoField.getText()).thenReturn("");
        when(descricaoField.getText()).thenReturn("");

        cadastrarONGController.onSalvarAction();

        verify(ValidacaoUtils.class);
    }
}
