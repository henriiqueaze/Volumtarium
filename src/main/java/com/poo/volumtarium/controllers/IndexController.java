package com.poo.volumtarium.controllers;

import com.poo.volumtarium.utils.TelaUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class IndexController {

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
        TelaUtils.abrirNovaTela(cadastrarONG.getScene().getWindow(),"cadastrarOportunidade.fxml", "Cadastrar Oportunidade");
    }

    @FXML
    public void onCadastrarONGAction() {
        TelaUtils.abrirNovaTela(cadastrarONG.getScene().getWindow(),"cadastrarOng.fxml", "Cadastrar ONG");
    }

    @FXML
    public void onCadastrarVoluntarioAction() {
        TelaUtils.abrirNovaTela(cadastrarONG.getScene().getWindow(),"cadastrarVoluntario.fxml", "Cadastrar Voluntário");
    }

    @FXML
    public void onListarProcessosAction() {
        TelaUtils.abrirNovaTela(cadastrarONG.getScene().getWindow(),"listarProcessos.fxml", "Listar Processos");
    }

    @FXML
    public void onRegistrarParticipacaoAction() {
        TelaUtils.abrirNovaTela(cadastrarONG.getScene().getWindow(), "registrarParticipacao.fxml", "Registrar Participação");
    }
}
