package com.poo.volumtarium.controllers;

import com.poo.volumtarium.utils.TelaUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ListarProcessosController {

    @FXML
    private Button voltar;

    @FXML
    public void onVoltarAction() {
        TelaUtils.abrirNovaTela(voltar.getScene().getWindow(), "index.fxml", "Menu Principal");
    }
}
