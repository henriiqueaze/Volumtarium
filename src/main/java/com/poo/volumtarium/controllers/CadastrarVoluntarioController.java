package com.poo.volumtarium.controllers;

import com.poo.volumtarium.model.entities.Gerenciador;
import com.poo.volumtarium.model.entities.Voluntario;
import com.poo.volumtarium.model.entities.VoluntarioLocal;
import com.poo.volumtarium.model.entities.VoluntarioRemoto;
import com.poo.volumtarium.model.exceptions.EntradaNaoEsperada;
import com.poo.volumtarium.model.exceptions.FaltandoCampoException;
import com.poo.volumtarium.model.exceptions.IdadeIncorreta;
import com.poo.volumtarium.utils.TelaUtils;
import com.poo.volumtarium.utils.ValidacaoUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class CadastrarVoluntarioController {

    @FXML
    private ImageView voltar;

    @FXML
    private Button salvar;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField idadeField;

    @FXML
    private TextField localizacaoField;

    @FXML
    private TextField contatoField;

    @FXML
    private ListView<String> tipoVoluntarioField;

    private ObservableList<String> listaDeTipos;

    private Gerenciador gerenciador;

    @FXML
    public void initialize() {
        System.out.println("initialize chamado");

        this.gerenciador = new Gerenciador();
        listaDeTipos = FXCollections.observableArrayList("Voluntário Local", "Voluntário Remoto");

        if (tipoVoluntarioField != null) {
            tipoVoluntarioField.setItems(listaDeTipos);

            tipoVoluntarioField.setCellFactory(param -> new ListCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty || item == null ? null : item);
                }
            });
        } else {
            System.out.println("Erro: tipoVoluntarioField não foi inicializado.");
        }
    }

    @FXML
    public void onSalvarAction() {
        try {
            Voluntario novoVoluntario = criarVoluntarioAPartirCampos();

            gerenciador.cadastrarVoluntario(novoVoluntario.getNome(), novoVoluntario.getIdade(), novoVoluntario.getLocalizacao(), novoVoluntario.getContato(), (byte) (novoVoluntario instanceof VoluntarioLocal ? 1 : 2));
            System.out.println("Voluntário criado com sucesso: " + novoVoluntario);

            ValidacaoUtils.exibirMensagemSucesso("Voluntário cadastrado com sucesso!");
        }

        catch (FaltandoCampoException | IllegalArgumentException | IdadeIncorreta | EntradaNaoEsperada e) {
            ValidacaoUtils.exibirMensagemErro("Erro ao cadastrar voluntário: " + e.getMessage());
        }
    }

    private Voluntario criarVoluntarioAPartirCampos() throws FaltandoCampoException {
        String nome = nomeField.getText();
        String idade = idadeField.getText();
        String localizacao = localizacaoField.getText();
        String contato = contatoField.getText();
        String tipoSelecionado = tipoVoluntarioField.getSelectionModel().getSelectedItem(); // Obtém a seleção da ListView

        ValidacaoUtils.validarCamposObrigatorios(nome, idade, contato, tipoSelecionado);

        if (!ValidacaoUtils.isNumeric(idade)) {
            throw new IllegalArgumentException("Idade deve ser um número válido.");
        }

        int idadeNumerica = Integer.parseInt(idade);

        if ("Voluntário Local".equals(tipoSelecionado)) {
            return new VoluntarioLocal(0, nome, idadeNumerica, localizacao, contato);
        }

        else if ("Voluntário Remoto".equals(tipoSelecionado)) {
            return new VoluntarioRemoto(0, nome, idadeNumerica, localizacao, contato);
        }

        else {
            throw new FaltandoCampoException("Tipo de voluntário não selecionado.");
        }
    }

    @FXML
    public void onVoltarAction() {
        TelaUtils.abrirNovaTela(voltar.getScene().getWindow(), "index.fxml", "Menu Principal");
    }
}
