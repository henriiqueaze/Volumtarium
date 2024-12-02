package com.poo.volumtarium.controllers;

import com.poo.volumtarium.model.entities.ONG;
import com.poo.volumtarium.model.entities.Oportunidade;
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

    @FXML
    public void initialize() {

        listaDeOngs = FXCollections.observableArrayList();

        ONGField.setItems(listaDeOngs);

        listaDeOngs.add(new ONG("ONG A", "Endereço A", "Saúde", "Descrição A", "Contato A"));
        listaDeOngs.add(new ONG("ONG B", "Endereço B", "Educação", "Descrição B", "Contato B"));
        listaDeOngs.add(new ONG("ONG C", "Endereço C", "Meio Ambiente", "Descrição C", "Contato C"));

        ONGField.setCellFactory(param -> new javafx.scene.control.ListCell<>() {
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
            System.out.println("Oportunidade criada com sucesso: " + novaOportunidade);

            ValidacaoUtils.exibirMensagemSucesso("Oportunidade cadastrada com sucesso!");
        }

        catch (FaltandoCampoException e) {
            ValidacaoUtils.exibirMensagemErro("Erro ao cadastrar oportunidade: " + e.getMessage());
        }
    }

    private Oportunidade criarOportunidadeAPartirCampos() throws FaltandoCampoException {
        String requesitos = requesitosField.getText();
        ONG ongSelecionada = ONGField.getSelectionModel().getSelectedItem();
        String descricao = descricaoField.getText();

        ValidacaoUtils.validarCamposObrigatorios(requesitos, descricao, ongSelecionada);

        return new Oportunidade(requesitos, descricao, ongSelecionada);
    }

    @FXML
    public void onVoltarAction() {
        TelaUtils.abrirNovaTela(voltar.getScene().getWindow(), "index.fxml", "Menu Principal");
    }
}
