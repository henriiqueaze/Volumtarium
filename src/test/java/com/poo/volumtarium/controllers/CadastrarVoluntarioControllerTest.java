package com.poo.volumtarium.controllers;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.poo.volumtarium.controllers.CadastrarVoluntarioController;
import com.poo.volumtarium.model.exceptions.EntradaNaoEsperada;
import com.poo.volumtarium.model.exceptions.FaltandoCampoException;
import com.poo.volumtarium.model.entities.Gerenciador;
import com.poo.volumtarium.model.exceptions.IdadeIncorreta;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class CadastrarVoluntarioControllerTest {

    @Mock
    private Gerenciador gerenciador;

    @InjectMocks
    private CadastrarVoluntarioController cadastrarVoluntarioController;

    private TextField nomeField;
    private TextField idadeField;
    private TextField contatoField;
    private ComboBox<String> tipoVoluntarioField;

    @BeforeEach
    public void setUp() {
        nomeField = mock(TextField.class);
        idadeField = mock(TextField.class);
        contatoField = mock(TextField.class);
        tipoVoluntarioField = mock(ComboBox.class);
    }

    @Test
    public void testCadastrarVoluntarioComSucesso() throws FaltandoCampoException, IdadeIncorreta, EntradaNaoEsperada {
        when(nomeField.getText()).thenReturn("Voluntário Teste");
        when(idadeField.getText()).thenReturn("30");
        when(contatoField.getText()).thenReturn("contato@voluntario.com");
        when(tipoVoluntarioField.getSelectionModel().getSelectedItem()).thenReturn("Voluntário Local");

        cadastrarVoluntarioController.onSalvarAction();

        verify(gerenciador).cadastrarVoluntario(anyString(), anyInt(), anyString(), anyString(), anyByte());
    }
}
