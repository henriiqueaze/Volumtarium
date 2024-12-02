package com.poo.volumtarium.controllers;

import com.poo.volumtarium.utils.TelaUtils;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class CadastrarVoluntarioController {

    @FXML
    private ImageView voltar;

    @FXML
    public void onVoltarAction() {
        TelaUtils.abrirNovaTela(voltar.getScene().getWindow(), "index.fxml", "Menu Principal");
    }
}
