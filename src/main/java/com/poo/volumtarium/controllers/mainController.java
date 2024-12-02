package com.poo.volumtarium.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class mainController {

    @FXML
    private Button cadastrarONG;

    @FXML
    private Button cadastrarOportunidade;

    @FXML
    private Button cadastrarVoluntario;

    @FXML
    private Button listarProcessos;

    @FXML
    private Button registrarParticipacao;

    @FXML
    public void onCadastrarOportunidadeAction() {
        abrirNovaTela("cadastrarOportunidade.fxml", "Cadastrar Oportunidade");
    }

    @FXML
    public void onCadastrarONGAction() {
        abrirNovaTela("cadastrarOng.fxml", "Cadastrar ONG");
    }

    @FXML
    public void onCadastrarVoluntarioAction() {
        abrirNovaTela("cadastrarVoluntario.fxml", "Cadastrar Voluntário");
    }

    @FXML
    public void onListarProcessosAction() {
        abrirNovaTela("listarProcessos.fxml", "Listar Processos");
    }

    @FXML
    public void onRegistrarParticipacaoAction() {
        abrirNovaTela("registrarParticipacao-view.fxml", "Registrar Participação");
    }

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
        Window window = cadastrarONG.getScene().getWindow();

        if (window instanceof Stage) {
            ((Stage) window).close();
        }
    }
}
