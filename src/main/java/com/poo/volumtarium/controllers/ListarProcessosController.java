package com.poo.volumtarium.controllers;

import com.poo.volumtarium.model.entities.Gerenciador;
import com.poo.volumtarium.model.entities.ONG;
import com.poo.volumtarium.model.entities.Oportunidade;
import com.poo.volumtarium.model.entities.Voluntario;
import com.poo.volumtarium.model.entities.VoluntarioLocal;
import com.poo.volumtarium.model.entities.VoluntarioRemoto;
import com.poo.volumtarium.utils.TelaUtils;
import com.poo.volumtarium.utils.ValidacaoUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ListarProcessosController {

    @FXML
    private Button voltar;

    @FXML
    private ListView<ONG> listaOngsView;

    @FXML
    private ListView<Oportunidade> listaOportunidadesView;

    @FXML
    private ListView<Voluntario> listaVoluntariosView;

    private Gerenciador gerenciador;
    private ObservableList<ONG> listaOngs;
    private ObservableList<Oportunidade> listaOportunidades;
    private ObservableList<Voluntario> listaVoluntarios;

    //pedi pro chatgpt tentar fazer e ainda n foi :(

    @FXML
    public void initialize() {
        this.gerenciador = Gerenciador.getInstance();

        if (gerenciador.getOngs().isEmpty() && gerenciador.getOportunidades().isEmpty() && gerenciador.getVoluntarios().isEmpty()) {
            ValidacaoUtils.exibirMensagemErro("Todos os campos estão vazios");
        }

        listaOngs = FXCollections.observableArrayList(gerenciador.getOngs());
        listaOportunidades = FXCollections.observableArrayList(gerenciador.getOportunidades());
        listaVoluntarios = FXCollections.observableArrayList(gerenciador.getVoluntarios());

        listaOngsView.setItems(listaOngs);
        listaOportunidadesView.setItems(listaOportunidades);
        listaVoluntariosView.setItems(listaVoluntarios);

        listaOngsView.setCellFactory(param -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(ONG item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNome());
            }
        });

        listaOportunidadesView.setCellFactory(param -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Oportunidade item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getDescricao());
            }
        });

        listaVoluntariosView.setCellFactory(param -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Voluntario item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                }

                else if (item instanceof VoluntarioLocal) {
                    VoluntarioLocal local = (VoluntarioLocal) item;
                    setText(local.getNome() + " (Local: " + local.getLocalizacao() + ")");
                }

                else if (item instanceof VoluntarioRemoto) {
                    VoluntarioRemoto remoto = (VoluntarioRemoto) item;
                    setText(remoto.getNome() + " (Remoto: " + remoto.getContato() + ")");
                }
            }
        });
    }

    @FXML
    public void onVoltarAction() {
        TelaUtils.abrirNovaTela(voltar.getScene().getWindow(), "index.fxml", "Menu Principal");
    }

    public void onListarVoluntarios() {
        gerenciador.getVoluntarios();
    }
}
