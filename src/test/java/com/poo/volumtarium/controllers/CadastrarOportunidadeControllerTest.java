package com.poo.volumtarium.controllers;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.poo.volumtarium.controllers.CadastrarOportunidadeController;

import com.poo.volumtarium.model.entities.ONG;
import com.poo.volumtarium.model.entities.Gerenciador;
import com.poo.volumtarium.model.entities.Oportunidade;
import com.poo.volumtarium.model.exceptions.FaltandoCampoException;
import com.poo.volumtarium.model.exceptions.EntradaNaoEsperada;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class CadastrarOportunidadeControllerTest {

    @Mock
    private Gerenciador gerenciador;

    @InjectMocks
    private CadastrarOportunidadeController cadastrarOportunidadeController;

    private ListView<ONG> ONGField;
    private TextField descricaoField;
    private TextField nomeField;

    @BeforeEach
    public void setUp() {
        ONGField = mock(ListView.class);
        descricaoField = mock(TextField.class);
        nomeField = mock(TextField.class);
    }

    @Test
    public void testCadastrarOportunidadeComSucesso() throws FaltandoCampoException, EntradaNaoEsperada {
        when(ONGField.getSelectionModel().getSelectedItem()).thenReturn(new ONG(1, "ONG Teste", "Rua Teste", "Educação", "Descrição", "contato@ong.com"));
        when(descricaoField.getText()).thenReturn("Oportunidade Teste");
        when(nomeField.getText()).thenReturn("Requisitos");

        cadastrarOportunidadeController.onSalvarAction();

        verify(gerenciador).addOportunidade(any(Oportunidade.class));
    }
}
