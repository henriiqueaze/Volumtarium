package com.poo.volumtarium.controllers;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.poo.volumtarium.model.entities.Oportunidade;
import com.poo.volumtarium.model.entities.Voluntario;
import com.poo.volumtarium.model.entities.Gerenciador;
import com.poo.volumtarium.model.exceptions.EntradaNaoEsperada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class RegistrarParticipacaoControllerTest {

    @Mock
    private Gerenciador gerenciador;

    @Mock
    private ListView<Voluntario> voluntarioField;

    @Mock
    private ListView<Oportunidade> oportunidadeField;

    @InjectMocks
    private RegistrarParticipacaoController registrarParticipacaoController;

    @Mock
    private ImageView voltar;

    @BeforeEach
    public void setUp() {
        Voluntario voluntarioMock = mock(Voluntario.class);
        Oportunidade oportunidadeMock = mock(Oportunidade.class);

        ObservableList<Voluntario> voluntarios = FXCollections.observableArrayList(voluntarioMock);
        when(voluntarioField.getItems()).thenReturn(voluntarios);
        when(voluntarioField.getSelectionModel().getSelectedItem()).thenReturn(voluntarioMock);

        ObservableList<Oportunidade> oportunidades = FXCollections.observableArrayList(oportunidadeMock);
        when(oportunidadeField.getItems()).thenReturn(oportunidades);
        when(oportunidadeField.getSelectionModel().getSelectedItem()).thenReturn(oportunidadeMock);

        registrarParticipacaoController.initialize();
    }

    @Test
    public void testRegistrarParticipacao() throws EntradaNaoEsperada {
        Voluntario voluntarioMock = voluntarioField.getSelectionModel().getSelectedItem();
        Oportunidade oportunidadeMock = oportunidadeField.getSelectionModel().getSelectedItem();

        registrarParticipacaoController.onSalvarAction();

        verify(gerenciador).registrarParticipacao(voluntarioMock);
    }

    @Test
    public void testRegistrarParticipacaoComErro() {
        when(voluntarioField.getSelectionModel().getSelectedItem()).thenReturn(null);

        assertThrows(EntradaNaoEsperada.class, () -> {
            registrarParticipacaoController.onSalvarAction();
        });
    }
}
