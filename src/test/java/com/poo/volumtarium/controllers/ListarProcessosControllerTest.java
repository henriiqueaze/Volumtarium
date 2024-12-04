package com.poo.volumtarium.controllers;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.poo.volumtarium.model.entities.Gerenciador;
import com.poo.volumtarium.model.entities.Voluntario;
import javafx.scene.control.ListView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;

public class ListarProcessosControllerTest {

    @Mock
    private Gerenciador gerenciador;

    @InjectMocks
    private ListarProcessosController listarProcessosController;

    @Mock
    private ListView<Voluntario> voluntariosList;

    @BeforeEach
    public void setUp() {
        voluntariosList = mock(ListView.class);
        when(gerenciador.getVoluntarios()).thenReturn(new ArrayList<>());
        listarProcessosController.initialize();
    }

    @Test
    public void testListarVoluntarios() {
        listarProcessosController.onListarVoluntarios();
        verify(gerenciador).getVoluntarios();
    }
}
