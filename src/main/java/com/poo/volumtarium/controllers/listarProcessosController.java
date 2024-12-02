package com.poo.volumtarium.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class listarProcessosController {

    @FXML
    private Button voltar;

    @FXML
    public void onVoltarAction() {
        abrirNovaTela("main.fxml", "Cadastrar Oportunidade");
    }

    @FXML
    private void abrirNovaTela(String fxmlArquivo, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/poo/volumtarium/views/" + fxmlArquivo));
            Parent root = loader.load();

            Stage novaTela = new Stage();
            novaTela.setTitle(titulo);
            novaTela.setScene(new Scene(root));
            novaTela.show();

            fecharJanelaAtual();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fecharJanelaAtual() {
        Window window = voltar.getScene().getWindow();

        if (window instanceof Stage) {
            ((Stage) window).close();
        }
    }
}
