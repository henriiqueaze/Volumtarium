package com.poo.volumtarium.controllers;

import com.poo.volumtarium.model.entities.Gerenciador;
import com.poo.volumtarium.model.entities.ONG;
import com.poo.volumtarium.model.entities.Oportunidade;
import com.poo.volumtarium.model.exceptions.EntradaNaoEsperada;
import com.poo.volumtarium.model.exceptions.FaltandoCampoException;
import com.poo.volumtarium.utils.TelaUtils;
import com.poo.volumtarium.utils.ValidacaoUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CadastrarOportunidadeController {

    @FXML
    private ImageView voltar;

    @FXML
    private Button salvar;

    @FXML
    private TextField requesitosField;

    @FXML
    private ListView<ONG> ONGField;

    @FXML
    private TextField descricaoField;

    private ObservableList<ONG> listaDeOngs;

    private Gerenciador gerenciador;

    @FXML
    public void initialize() {
        this.gerenciador = Gerenciador.getInstance();

        listaDeOngs = FXCollections.observableArrayList();

        ONGField.setItems(listaDeOngs);

        listaDeOngs.addAll(gerenciador.getOngs());

        ONGField.setCellFactory(param -> new javafx.scene.control.ListCell<ONG>() {
            @Override
            protected void updateItem(ONG item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                }

                else {
                    setText(item.getNome());
                }
            }
        });
    }

    @FXML
    public void onSalvarAction() {
        try {
            Oportunidade novaOportunidade = criarOportunidadeAPartirCampos();

            Oportunidade oportunidade = new Oportunidade(0, novaOportunidade.getDescricao(), novaOportunidade.getRequisitos(), novaOportunidade.getONG());
            gerenciador.addOportunidade(oportunidade);
            System.out.println("Oportunidade criada com sucesso: " + novaOportunidade);

            ValidacaoUtils.exibirMensagemSucesso("Oportunidade cadastrada com sucesso!");
        }

        catch (FaltandoCampoException e) {
            ValidacaoUtils.exibirMensagemErro("Erro ao cadastrar oportunidade: " + e.getMessage());
        }

        catch (EntradaNaoEsperada e) {
            ValidacaoUtils.exibirMensagemErro("Erro inesperado: " + e.getMessage());
        }
    }

    private Oportunidade criarOportunidadeAPartirCampos() throws EntradaNaoEsperada {
        String requisitos = requesitosField.getText();
        ONG ongSelecionada = ONGField.getSelectionModel().getSelectedItem();
        String descricao = descricaoField.getText();

        ValidacaoUtils.validarCamposObrigatorios(requisitos, descricao, ongSelecionada);

        return new Oportunidade(0, descricao, requisitos, ongSelecionada);
    }

    @FXML
    public void onVoltarAction() {
        TelaUtils.abrirNovaTela(voltar.getScene().getWindow(), "index.fxml", "Menu Principal");
    }

}
