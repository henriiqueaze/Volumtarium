package com.poo.volumtarium.controllers;

import com.poo.volumtarium.model.entities.Gerenciador;
import com.poo.volumtarium.model.entities.Oportunidade;
import com.poo.volumtarium.model.entities.Voluntario;
import com.poo.volumtarium.model.exceptions.EntradaNaoEsperada;
import com.poo.volumtarium.utils.TelaUtils;
import com.poo.volumtarium.utils.ValidacaoUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class RegistrarParticipacaoController {

    @FXML
    private ImageView voltar;

    @FXML
    private Button salvar;

    @FXML
    private ListView<Voluntario> voluntarioField;

    @FXML
    private ListView<Oportunidade> oportunidadeField;

    private Gerenciador gerenciador;

    @FXML
    public void initialize() {
        this.gerenciador = new Gerenciador();

        ObservableList<Voluntario> listaVoluntarios = FXCollections.observableArrayList(gerenciador.getVoluntarios());
        voluntarioField.setItems(listaVoluntarios);

        ObservableList<Oportunidade> listaOportunidades = FXCollections.observableArrayList(gerenciador.getOportunidades());
        oportunidadeField.setItems(listaOportunidades);
    }

    @FXML
    public void onSalvarAction() {
        try {
            Oportunidade oportunidadeSelecionada = oportunidadeField.getSelectionModel().getSelectedItem();
            if (oportunidadeSelecionada == null) {
                throw new EntradaNaoEsperada("Selecione uma oportunidade.");
            }

            Voluntario voluntarioSelecionado = voluntarioField.getSelectionModel().getSelectedItem();
            if (voluntarioSelecionado == null) {
                throw new EntradaNaoEsperada("Selecione um voluntário.");
            }

            gerenciador.registrarParticipacao(voluntarioSelecionado, oportunidadeSelecionada);

            ValidacaoUtils.exibirMensagemSucesso("Participação registrada com sucesso!");
        }

        catch (EntradaNaoEsperada e) {
            ValidacaoUtils.exibirMensagemErro("Erro ao registrar participação: " + e.getMessage());
        }
    }

    @FXML
    public void onVoltarAction() {
        TelaUtils.abrirNovaTela(voltar.getScene().getWindow(), "index.fxml", "Menu Principal");
    }
}
